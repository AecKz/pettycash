-- Database: pettycash

-- DROP DATABASE pettycash;

CREATE DATABASE pettycash
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

-- Table: public.cuenta

-- DROP TABLE public.cuenta;

CREATE TABLE public.cuenta
(
    id bigint NOT NULL,
    montocuenta double precision NOT NULL,
    tipotransaccion character varying(10) COLLATE pg_catalog."default" NOT NULL,
    fechatransaccion time with time zone,
    CONSTRAINT cuenta_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.cuenta
    OWNER to postgres;
	
-- Table: public.deposito

-- DROP TABLE public.deposito;

CREATE TABLE public.deposito
(
    id bigint NOT NULL,
    idusuario bigint NOT NULL,
    montodeposito double precision NOT NULL,
    CONSTRAINT deposito_pkey PRIMARY KEY (id),
    CONSTRAINT fkdepositousuario FOREIGN KEY (idusuario)
        REFERENCES public.usuario (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.deposito
    OWNER to postgres;

-- Table: public.pedido

-- DROP TABLE public.pedido;

CREATE TABLE public.pedido
(
    id bigint NOT NULL,
    nombre character varying(250) COLLATE pg_catalog."default" NOT NULL,
    montopedido double precision NOT NULL,
    estado character varying(25) COLLATE pg_catalog."default" NOT NULL,
    fechapedido time with time zone NOT NULL,
    CONSTRAINT pedido_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pedido
    OWNER to postgres;

-- Table: public.retiro

-- DROP TABLE public.retiro;

CREATE TABLE public.retiro
(
    id bigint NOT NULL,
    idpedido bigint NOT NULL,
    fechaaprueba time with time zone NOT NULL,
    CONSTRAINT retiro_pkey PRIMARY KEY (id),
    CONSTRAINT fkgrirlk2pgct8bjxdmkepbcvw7 FOREIGN KEY (idpedido)
        REFERENCES public.pedido (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkpedidoretiro FOREIGN KEY (idpedido)
        REFERENCES public.pedido (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.retiro
    OWNER to postgres;

-- Table: public.usuario

-- DROP TABLE public.usuario;

CREATE TABLE public.usuario
(
    id bigint NOT NULL,
    usuario character varying(10) COLLATE pg_catalog."default" NOT NULL,
    clave character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to postgres;

--Valores Iniciales
--Importante!!
insert into cuenta (id, montocuenta, tipotransaccion, fechatransaccion) 
values (1, 500, 'DEPOSITO', current_timestamp);
insert into usuario (id,usuario,clave) values (1,'CUSTODIO','12345');
