CREATE TABLE TENANT
(
  ID   varchar(100) not null
);

INSERT INTO TENANT (id) VALUES ('a');
INSERT INTO TENANT (id) VALUES ('b');

CREATE SCHEMA A;

SET SCHEMA A;

CREATE TABLE BARBER
(
  ID   int          not null auto_increment,
  NAME varchar(100) not null
);

CREATE TABLE APPOINTMENT
(
  ID           int not null auto_increment,
  BARBER_ID    int,
  DATE_TIME    timestamp,
  CLIENT_NAME  varchar(100),
  CLIENT_PHONE varchar(100)
);

INSERT INTO BARBER (name) VALUES ('Johnny from (a)');
INSERT INTO BARBER (name) VALUES ('Jackie from (a)');
INSERT INTO BARBER (name) VALUES ('Bobby from (a)');
INSERT INTO BARBER (name) VALUES ('Charlie from (a)');

CREATE SCHEMA B;

SET SCHEMA B;

CREATE TABLE BARBER
(
  ID   int          not null auto_increment,
  NAME varchar(100) not null
);

CREATE TABLE APPOINTMENT
(
  ID           int not null auto_increment,
  BARBER_ID    int,
  DATE_TIME    timestamp,
  CLIENT_NAME  varchar(100),
  CLIENT_PHONE varchar(100)
);

INSERT INTO BARBER (name) VALUES ('Johnny from (b)');
INSERT INTO BARBER (name) VALUES ('Jackie from (b)');
INSERT INTO BARBER (name) VALUES ('Bobby from (b)');
INSERT INTO BARBER (name) VALUES ('Charlie from (b)');
