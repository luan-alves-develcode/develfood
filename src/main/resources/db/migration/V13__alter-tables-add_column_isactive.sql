ALTER TABLE plates ADD is_active BOOLEAN DEFAULT true NOT NULL;
ALTER TABLE restaurants ADD is_active BOOLEAN DEFAULT true NOT NULL;
ALTER TABLE restaurant_evaluations ADD is_active BOOLEAN DEFAULT true NOT NULL;
ALTER TABLE restaurant_promotions ADD is_active BOOLEAN DEFAULT true NOT NULL;