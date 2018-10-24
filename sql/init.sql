/*
 *
 * DDL all tables
 * 1) Role, User, User Role
 * 2) State, Train, Station, Schedule, Seat and Ticket
 *
 */


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

/*  User role table */
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

/* ====Core tables==== */

/* State table */
CREATE TABLE IF NOT EXISTS state (
  id INT AUTO_INCREMENT PRIMARY KEY,
  type VARCHAR(100) NULL,
  CONSTRAINT state_id_uindex UNIQUE (id)
)
  ENGINE=InnoDB;

/* Train table */
CREATE TABLE IF NOT EXISTS train (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (100) NULL,
  state_id INT NULL,
  carriages INT NULL,
  CONSTRAINT train_id_uindex UNIQUE (id),
  CONSTRAINT train_state_id_fk FOREIGN KEY (state_id) REFERENCES state (id)
)
  ENGINE=InnoDB;

/* Station table */
CREATE TABLE IF NOT EXISTS station (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR (100) NULL,
  latitude DOUBLE NULL,
  longitude DOUBLE NULL,
  state_id INT NULL,
  CONSTRAINT station_id_uindex UNIQUE (id),
  CONSTRAINT station_state_id_fk FOREIGN KEY (state_id) REFERENCES state (id)
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

/* Seat table */
CREATE TABLE IF NOT EXISTS seat (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  carriage INT NULL,
  seat INT NULL,
  train_id INT NULL,
  CONSTRAINT seat_id_uindex UNIQUE (id),
  CONSTRAINT seat_train_id_fk FOREIGN KEY (train_id) REFERENCES train (id)
)
  ENGINE=InnoDB;

CREATE INDEX seat_train_id_fk ON seat (train_id);

/* Ticket table */
CREATE TABLE IF NOT EXISTS ticket (
  id INT AUTO_INCREMENT PRIMARY KEY ,
  schedule_id INT NOT NULL,
  user_id INT NOT NULL ,
  seat_id INT NOT NULL ,
  price INT NULL ,
  CONSTRAINT ticket_id_uindex UNIQUE (id),
  CONSTRAINT ticket_schedule_id_fk FOREIGN KEY (schedule_id) REFERENCES schedule (id),
  CONSTRAINT ticket_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id),
  CONSTRAINT ticket_seat_id_fk FOREIGN KEY (seat_id) REFERENCES seat (id)
)
  ENGINE=InnoDB;

CREATE INDEX ticket_schedule_id_fk ON ticket (schedule_id);

CREATE INDEX ticket_seat_id_fk ON ticket (seat_id);

CREATE INDEX ticket_user_id_fk ON ticket (user_id);

/* ====MappingEdge system model mapping==== */

/* Branch table */
CREATE TABLE IF NOT EXISTS branch (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NULL
)
  ENGINE=InnoDB;


/* MappingEdge table */
CREATE TABLE IF NOT EXISTS edge (
  id INT AUTO_INCREMENT PRIMARY KEY,
  station_start_id INT NOT NULL,
  station_end_id INT NOT NULL,
  range_distance INT NULL,
  branch_id INT NOT NULL,
  CONSTRAINT edge_station_start_id_fk FOREIGN KEY (station_start_id) REFERENCES station (id),
  CONSTRAINT edge_station_end_id_fk FOREIGN KEY (station_end_id) REFERENCES station (id),
  CONSTRAINT edge_branch_id_fk FOREIGN KEY (branch_id) REFERENCES branch (id)
)
  ENGINE=InnoDB;

CREATE INDEX edge_station_start_id_fk ON edge (station_start_id);

CREATE INDEX edge_station_end_id_fk ON edge (station_end_id);

CREATE INDEX edge_branch_id_fk ON edge (branch_id);