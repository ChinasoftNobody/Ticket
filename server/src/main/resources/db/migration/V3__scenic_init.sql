DROP TABLE IF EXISTS t_scenic_basic;
CREATE TABLE t_scenic_basic(
  id VARCHAR(32) NOT NULL PRIMARY KEY ,
  store_id VARCHAR(32) NOT NULL ,
  name VARCHAR(128) NOT NULL ,
  description TEXT,
  address VARCHAR(200) NOT NULL ,
  image VARCHAR(200) NOT NULL
);

DROP TABLE IF EXISTS t_scenic_ticket;
CREATE TABLE t_scenic_ticket(
  id VARCHAR(32) NOT NULL PRIMARY KEY ,
  scenic_id VARCHAR(32) NOT NULL ,
  store_id VARCHAR(32) NOT NULL ,
  date DATE NOT NULL ,
  ticket_number INTEGER DEFAULT 0
);