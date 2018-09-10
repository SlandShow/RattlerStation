/* Insert all data to tables */

/* ====Spring Security tables==== */

/* Insert data to User table */
INSERT INTO user (id, firstName, lastName, login, password) VALUES (
  1,
  'Andy',
  'Crown',
  'andy@gmail.com',
  '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG'
);

INSERT INTO user (id, firstName, lastName, login, password) VALUES (
  2,
  'Apple',
  'Dragon',
  'appledragon@gmail.com',
  '$2a$10$uFTcPGrYCXZfM6pVYmxtNOvgV07ugeMLlXgaXVN4GGbaQRYHqfiOa'
);

/* Insert data to Role table */
INSERT INTO role (id, type) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, type) VALUES (2, 'ROLE_ADMIN');
INSERT INTO role (id, type) VALUES (3, 'ROLE_MANAGER');

/* Insert data to User role table */
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);

/* Insert data to  Train table */
INSERT INTO train (id, name) VALUES (1, 'Rocket'), (2, 'Meteor'), (3, 'Champion');

/* Insert data to Station table */
INSERT INTO station (id, name) VALUES (1, 'Saint-Petersburg'), (2, 'Moscow'), (3, 'Novgorod'), (4, 'Belgorod');

/* Insert data to Schedule table */
INSERT INTO schedule (id, date_departure, date_arrival, station_departure_id, station_arrival_id, train_id) VALUES
  (1, '2018-09-01 12:56:12', '2018-09-02 12:56:12', 1, 2, 1),
  (2, '2018-10-05 12:00:00', '2018-10-16 12:00:00', 1, 2, 2),
  (3, '2018-09-05 13:00:00', '2018-09-06 12:00:00', 1, 2, 1),
  (4, '2018-09-04 10:00:00', '2018-06-09 12:00:00', 2, 1, 3),
  (5, '2018-09-11 11:00:00', '2018-09-13 16:00:00', 2, 1, 1),
  (6, '2018-09-16 11:00:00', '2018-09-19 16:00:00', 1, 4, 1);

/* Insert data to Seat table */
insert into RattlerStation.seat (id, carriage, seat, train_id) VALUES
  (1, 1, 1, 1), (2, 1, 2, 1)