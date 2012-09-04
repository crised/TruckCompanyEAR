-- Database: truck_company

-- DROP DATABASE truck_company;

CREATE DATABASE truck_company WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default CONNECTION LIMIT = -1;

-- Table: tc_user

-- DROP TABLE tc_user;

CREATE TABLE tc_user
(
  id_user serial NOT NULL,
  username text NOT NULL,
  password text NOT NULL,
  CONSTRAINT pk_tc_user_id PRIMARY KEY (id_user),
  CONSTRAINT unique_tc_user_username UNIQUE (username )
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
  CONSTRAINT pk_tc_truck_id PRIMARY KEY (id_truck ),
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
  CONSTRAINT pk_tc_consumption_id PRIMARY KEY (id_consumption ),
  CONSTRAINT fk_tc_consumption_truck_id FOREIGN KEY (ctruck_id)
      REFERENCES tc_truck (id_truck) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE tc_consumption
  OWNER TO postgres;