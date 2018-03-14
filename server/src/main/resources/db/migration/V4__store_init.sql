DROP TABLE IF EXISTS t_store_basic;
CREATE TABLE t_store_basic(
  id VARCHAR(32) NOT NULL PRIMARY KEY ,
  name VARCHAR(128) NOT NULL ,
  description TEXT,
  owner VARCHAR(128) NOT NULL ,
  ownerPhone VARCHAR(128) NOT NULL
);

DROP TABLE IF EXISTS t_store_examine;
CREATE TABLE t_store_examine(
  id VARCHAR(32) NOT NULL PRIMARY KEY ,
  store_id VARCHAR(32) NOT NULL ,
  status ENUM('during','pass','failed') NOT NULL,
  message VARCHAR(128) DEFAULT '',
  examiner_id VARCHAR(32) DEFAULT ''
);

