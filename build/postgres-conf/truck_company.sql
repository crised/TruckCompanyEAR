-- Database: truck_company

-- DROP DATABASE truck_company;

CREATE DATABASE truck_company WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;

-- Table: tc_user

-- DROP TABLE tc_user;

CREATE TABLE tc_user
(
  id_user serial NOT NULL,
  username varchar(255) NOT NULL,
  password varchar(255) NOT NULL,
  deleted boolean NOT NULL DEFAULT FALSE,
  deleted_date timestamp,
  version integer NOT NULL,
  CONSTRAINT pk_tc_user_id PRIMARY KEY (id_user),
  CONSTRAINT unique_tc_user_username UNIQUE (username)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tc_user
  OWNER TO postgres;

-- Table: tc_truck

-- DROP TABLE tc_truck;

CREATE TABLE tc_truck
(
  id_truck integer NOT NULL,
  brand text NOT NULL,
  plate text NOT NULL,
  deleted boolean NOT NULL DEFAULT FALSE,
  deleted_date timestamp,
  version integer NOT NULL,  
  CONSTRAINT pk_tc_truck_id PRIMARY KEY (id_truck),
  CONSTRAINT unique_tc_truck_plate UNIQUE (plate )
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tc_truck
  OWNER TO postgres;

-- Table: tc_consumption

-- DROP TABLE tc_consumption;

CREATE TABLE tc_consumption
(
  id_consumption serial NOT NULL,
  consumption numeric(10,3) NOT NULL DEFAULT 0,
  ctruck_id serial NOT NULL,
  deleted boolean NOT NULL DEFAULT FALSE,
  deleted_date timestamp,
  version integer NOT NULL,  
  CONSTRAINT pk_tc_consumption_id PRIMARY KEY (id_consumption),
  CONSTRAINT fk_tc_consumption_truck_id FOREIGN KEY (ctruck_id)
      REFERENCES tc_truck (id_truck) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tc_consumption
  OWNER TO postgres;

-- Table: tc_role

-- DROP TABLE tc_role;

CREATE TABLE tc_role
(
  user_id serial NOT NULL,
  name character varying(255) NOT NULL,
  CONSTRAINT tc_role_pkey PRIMARY KEY (user_id),
  CONSTRAINT user_role FOREIGN KEY (user_id)
      REFERENCES tc_user (id_user) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tc_role
  OWNER TO postgres;

-- Index: fki_user_role

-- DROP INDEX fki_user_role;

CREATE INDEX fki_user_role
  ON tc_role
  USING btree
  (user_id);
  
-- Table: tc_audit

-- DROP TABLE tc_audit;

CREATE TABLE tc_audit
(
  id serial NOT NULL,
  action_name character varying(255) NOT NULL,
  create_date timestamp without time zone NOT NULL,
  user_id integer NOT NULL,
  consumption_id integer NOT NULL,
  CONSTRAINT tc_audit_pkey PRIMARY KEY (id),
  CONSTRAINT audit_consumption FOREIGN KEY (consumption_id)
      REFERENCES tc_consumption (id_consumption) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT audit_user FOREIGN KEY (user_id)
      REFERENCES tc_user (id_user) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tc_audit
  OWNER TO postgres;

-- Index: fki_audit_consumption

-- DROP INDEX fki_audit_consumption;

CREATE INDEX fki_audit_consumption
  ON tc_audit
  USING btree
  (consumption_id);

-- Index: fki_audit_user

-- DROP INDEX fki_audit_user;

CREATE INDEX fki_audit_user
  ON tc_audit
  USING btree
  (user_id);

CREATE SEQUENCE tc_truck_seq
   START 100
   MINVALUE 100;