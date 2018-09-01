/* Create all tables */

CREATE TABLE train (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR (100) NULL,
  seats INT NOT NULL
);

CREATE TABLE station (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR (100) NULL
);

CREATE TABLE schedule (
  id INT PRIMARY KEY AUTO_INCREMENT,
  date_departure TIMESTAMP NULL,
  date_arrival TIMESTAMP NULL,
  station_departure_id INT NULL,
  station_arrival_id INT NULL,
  train_id INT NULL,
  CONSTRAINT schedule_station_id_fk FOREIGN KEY (station_departure_id) REFERENCES station (id),
  CONSTRAINT schedule_station_id_fk_2 FOREIGN KEY (station_arrival_id) REFERENCES station (id),
	CONSTRAINT schedule_train_id_fk FOREIGN KEY(train_id) references train (id)
);