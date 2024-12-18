
    create table tb_customers (

        id bigint generated by default as identity,
        full_name varchar(100) not null,
        first_name varchar(20),
        last_name varchar(20),
        email varchar(100) unique,
        cpf varchar(14) unique,
        birth_date date,
        note text,

        cep varchar(10),
        public_place varchar(100),
        house_number varchar(20),
        supplement varchar(100),
        neighborhood varchar(100),
        city varchar(100),
        uf varchar(2),
        state varchar(100),
        region varchar(100),       

        active boolean,
        created_at TIMESTAMP WITHOUT TIME ZONE,
        updated_at TIMESTAMP WITHOUT TIME ZONE,

        primary key (id)
    );

    create table tb_customers_phones (
        customer_id bigint not null,
        phones_id bigint not null unique
    );

    create table tb_phones (
        id bigint generated by default as identity,
        number varchar(20) not null,
        type varchar(255) check (type in ('WHATSAPP','CELULAR','RESIDENCIAL','COMERCIAL')),
        primary key (id)
    );

    alter table if exists tb_customers_phones 
       add constraint FK9qx4l9abhgs8vs0jpvjaeytmc 
       foreign key (phones_id) 
       references tb_phones;

    alter table if exists tb_customers_phones 
       add constraint FK4ktrrwtgquprdtxvu420tybh7 
       foreign key (customer_id) 
       references tb_customers;

    create table tb_customers (
        active boolean,
        birth_date date,
        uf varchar(2),
        created_at TIMESTAMP WITHOUT TIME ZONE,
        id bigint generated by default as identity,
        updated_at TIMESTAMP WITHOUT TIME ZONE,
        cep varchar(10),
        cpf varchar(14) unique,
        first_name varchar(20),
        house_number varchar(20),
        last_name varchar(20),
        city varchar(100),
        email varchar(100) unique,
        full_name varchar(100) not null,
        neighborhood varchar(100),
        public_place varchar(100),
        region varchar(100),
        state varchar(100),
        supplement varchar(100),
        note text,
        primary key (id)
    );

    create table tb_customers_phones (
        customer_id bigint not null,
        phones_id bigint not null unique
    );

    create table tb_phones (
        id bigint generated by default as identity,
        number varchar(20) not null,
        type varchar(20) check (type in ('WHATSAPP','CELULAR','RESIDENCIAL','COMERCIAL')),
        primary key (id)
    );

    alter table if exists tb_customers_phones 
       add constraint FK9qx4l9abhgs8vs0jpvjaeytmc 
       foreign key (phones_id) 
       references tb_phones;

    alter table if exists tb_customers_phones 
       add constraint FK4ktrrwtgquprdtxvu420tybh7 
       foreign key (customer_id) 
       references tb_customers;

    create table tb_customers (
        active boolean,
        birth_date date,
        uf varchar(2),
        created_at TIMESTAMP WITHOUT TIME ZONE,
        id bigint generated by default as identity,
        updated_at TIMESTAMP WITHOUT TIME ZONE,
        cep varchar(10),
        cpf varchar(14) unique,
        first_name varchar(20),
        house_number varchar(20),
        last_name varchar(20),
        city varchar(100),
        email varchar(100) unique,
        full_name varchar(100) not null,
        neighborhood varchar(100),
        public_place varchar(100),
        region varchar(100),
        state varchar(100),
        supplement varchar(100),
        note text,
        primary key (id)
    );

    create table tb_customers_phones (
        customer_id bigint not null,
        phones_id bigint not null unique
    );

    create table tb_phones (
        id bigint generated by default as identity,
        number varchar(20) not null,
        type varchar(20) check (type in ('WHATSAPP','CELULAR','RESIDENCIAL','COMERCIAL')),
        primary key (id)
    );

    alter table if exists tb_customers_phones 
       add constraint FK9qx4l9abhgs8vs0jpvjaeytmc 
       foreign key (phones_id) 
       references tb_phones;

    alter table if exists tb_customers_phones 
       add constraint FK4ktrrwtgquprdtxvu420tybh7 
       foreign key (customer_id) 
       references tb_customers;

    create table tb_customers (
        active boolean,
        birth_date date,
        uf varchar(2),
        created_at TIMESTAMP WITHOUT TIME ZONE,
        id bigint generated by default as identity,
        updated_at TIMESTAMP WITHOUT TIME ZONE,
        cep varchar(10),
        cpf varchar(14) unique,
        first_name varchar(20),
        house_number varchar(20),
        last_name varchar(20),
        city varchar(100),
        email varchar(100) unique,
        full_name varchar(100) not null,
        neighborhood varchar(100),
        public_place varchar(100),
        region varchar(100),
        state varchar(100),
        supplement varchar(100),
        note text,
        primary key (id)
    );

    create table tb_customers_phones (
        customer_id bigint not null,
        phones_id bigint not null unique
    );

    create table tb_phones (
        id bigint generated by default as identity,
        number varchar(20) not null,
        type varchar(20) check (type in ('WHATSAPP','CELULAR','RESIDENCIAL','COMERCIAL')),
        primary key (id)
    );

    alter table if exists tb_customers_phones 
       add constraint FK9qx4l9abhgs8vs0jpvjaeytmc 
       foreign key (phones_id) 
       references tb_phones;

    alter table if exists tb_customers_phones 
       add constraint FK4ktrrwtgquprdtxvu420tybh7 
       foreign key (customer_id) 
       references tb_customers;
