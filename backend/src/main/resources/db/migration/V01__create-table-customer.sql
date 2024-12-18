CREATE TABLE IF NOT EXISTS tb_customers (

    id BIGINT CONSTRAINT pk_tb_customers_id PRIMARY KEY generated by default as identity,
    full_name VARCHAR(100) NOT NULL,
    first_name VARCHAR(20),
    last_name VARCHAR(20),
    email VARCHAR(100) UNIQUE,
    cpf VARCHAR(14) UNIQUE,
    birth_date DATE,
    note TEXT,

    cep VARCHAR(10),
    public_place VARCHAR(100),
    house_number VARCHAR(20),
    supplement VARCHAR(100),
    neighborhood VARCHAR(100),
    city VARCHAR(100),
    uf VARCHAR(2),
    state VARCHAR(100),
    region VARCHAR(100),

    active BOOLEAN,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE
);