/* DDL all tables */


/* ====Spring Security tables==== */

/* User table */
CREATE TABLE IF NOT EXISTS user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  firstName VARCHAR(100) NOT NULL,
  lastName VARCHAR(100) NOT NULL,
  login VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  CONSTRAINT user_id_uindex UNIQUE (id)
)
  ENGINE=InnoDB;

/* Role table */
CREATE TABLE IF NOT EXISTS role (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  type VARCHAR(50) NULL ,
  CONSTRAINT role_id_uindex UNIQUE (id)
)
  engine=InnoDB;

/*  User role table*/
CREATE TABLE IF NOT EXISTS user_role (
  user_id INT NULL ,
  role_id INT NULL ,
  CONSTRAINT user_role_user_id_fk
  FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT user_role_role_id_fk
  FOREIGN KEY (role_id) REFERENCES role (id)
)
  ENGINE=InnoDB;

CREATE INDEX user_role_role_id_fk ON user_role (role_id);

CREATE INDEX user_role_user_id_fk ON user_role (user_id);

/* ====Core tables====

/* Train table */
CREATE TABLE IF NOT EXISTS train (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (100) NULL,
  seats INT NOT NULL
)
  ENGINE=InnoDB;

/* Station table */
CREATE TABLE IF NOT EXISTS station (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (100) NULL
)
  ENGINE=InnoDB;

/* Schedule table */
CREATE TABLE IF NOT EXISTS schedule (
  id INT AUTO_INCREMENT PRIMARY KEY,
  date_departure TIMESTAMP NULL,
  date_arrival TIMESTAMP NULL,
  station_departure_id INT NULL,
  station_arrival_id INT NULL,
  train_id INT NULL,
  CONSTRAINT schedule_station_id_fk FOREIGN KEY (station_departure_id) REFERENCES station (id),
  CONSTRAINT schedule_station_id_fk_2 FOREIGN KEY (station_arrival_id) REFERENCES station (id),
	CONSTRAINT schedule_train_id_fk FOREIGN KEY(train_id) references train (id)
)
  ENGINE=InnoDB;

CREATE INDEX schedule_station_id_fk
  ON schedule (station_departure_id)
;

CREATE INDEX schedule_station_id_fk_2
  ON schedule (station_arrival_id)
;

CREATE INDEX schedule_train_id_fk
  ON schedule (train_id)
;