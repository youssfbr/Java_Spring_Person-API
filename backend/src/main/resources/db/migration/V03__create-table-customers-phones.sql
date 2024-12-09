CREATE TABLE IF NOT EXISTS tb_customers_phones (
	customer_id BIGINT NOT NULL,
	phones_id BIGINT NOT NULL UNIQUE
);
