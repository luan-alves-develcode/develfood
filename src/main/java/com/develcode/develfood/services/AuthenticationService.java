package com.develcode.develfood.services;

import com.develcode.develfood.dto.AuthData;
import com.develcode.develfood.exception.ValidationException;
import com.develcode.develfood.infra.security.JwtService;
import com.develcode.develfood.model.User;
import com.develcode.develfood.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements UserDetailsService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    private final UserService userService;

    public String emailPasswordLoginAndGetToken(AuthData authData, AuthenticationManager authenticationManager) {
        try {
            var authenticationToken = new UsernamePasswordAuthenticationToken(authData.getEmail(), authData.getPassword());
            var authentication = authenticationManager.authenticate(authenticationToken);
            return jwtService.generateToken( (User) authentication.getPrincipal());
        } catch (ValidationException exception) {
            throw new ValidationException("Invalid email or password");
        }
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User credential are invalid"));
    }
}
