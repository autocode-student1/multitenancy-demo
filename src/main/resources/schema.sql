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

INSERT INTO BARBER (name) VALUES ('Johnny');
INSERT INTO BARBER (name) VALUES ('Jackie');
INSERT INTO BARBER (name) VALUES ('Bobby');
INSERT INTO BARBER (name) VALUES ('Charlie');
