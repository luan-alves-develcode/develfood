CREATE TABLE users (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   email VARCHAR(100) NOT NULL,
   password VARCHAR(80) NOT NULL,
   login_date TIMESTAMP WITHOUT TIME ZONE,
   role SMALLINT NOT NULL,
   active BOOLEAN NOT NULL,
   CONSTRAINT pk_users PRIMARY KEY (id)
);