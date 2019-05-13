CREATE TABLE BARBER
(
  ID   int          not null auto_increment,
  NAME varchar(100) not null,
  TENANT_ID varchar(100) not null
);

CREATE TABLE APPOINTMENT
(
  ID           int not null auto_increment,
  BARBER_ID    int,
  DATE_TIME    timestamp,
  CLIENT_NAME  varchar(100),
  CLIENT_PHONE varchar(100),
  TENANT_ID varchar(100) not null
);

CREATE TABLE TENANT
(
  ID   varchar(100) not null
);

INSERT INTO TENANT (id) VALUES ('a');
INSERT INTO TENANT (id) VALUES ('b');

INSERT INTO BARBER (name, tenant_id) VALUES ('Johnny from (a)', 'a');
INSERT INTO BARBER (name, tenant_id) VALUES ('Jackie from (a)', 'a');
INSERT INTO BARBER (name, tenant_id) VALUES ('Bobby from (a)', 'a');
INSERT INTO BARBER (name, tenant_id) VALUES ('Charlie from (a)', 'a');

INSERT INTO BARBER (name, tenant_id) VALUES ('Johnny from (b)', 'b');
INSERT INTO BARBER (name, tenant_id) VALUES ('Jackie from (b)', 'b');
INSERT INTO BARBER (name, tenant_id) VALUES ('Bobby from (b)', 'b');
INSERT INTO BARBER (name, tenant_id) VALUES ('Charlie from (b)', 'b');
