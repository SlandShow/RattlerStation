/* Insert all data to tables */

/* ====Spring Security tables==== */

/* Insert data to User table */
INSERT INTO user (id, firstName, lastName, login, password) VALUES (
  1,
  'Super',
  'User',
  'super-user@admin',
  '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG'
);

INSERT INTO user (id, firstName, lastName, login, password) VALUES (
  2,
  'Apple',
  'Dragon',
  'appledragon@gmail.com',
  '$2a$10$uFTcPGrYCXZfM6pVYmxtNOvgV07ugeMLlXgaXVN4GGbaQRYHqfiOa'
);

INSERT INTO user(id, firstName, lastName, login, password) VALUES (
  3,
  'Sland',
  'Show',
  'slandshow@mail.ru',
  '$2a$10$cHlfwXb/ZAGBcnApU/Q/U.7d0TPwZaJiRUiU4XIuYaSf6q/vw51bW'
);

/* Insert data to Role table */
INSERT INTO role (id, type) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, type) VALUES (2, 'ROLE_ADMIN');
INSERT INTO role (id, type) VALUES (3, 'ROLE_MANAGER');

/* Insert data to User role table */
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO user_role(user_id, role_id) VALUES (3, 3);

/* Insert Data to State table */
INSERT INTO state (id, type) VALUES
  (1, 'VALID'),
  (2, 'INVALID'),
  (3, 'UNUSED');

/* Insert data to Train table */
INSERT INTO train (id, name, state_id, carriages) VALUES
  (1, 'Spb trains #1', 3, 1),
  (2, 'Vsevolgsk trains', 3, 1),
  (3, 'Aqua', 3, 2),
  (4, 'Mars', 3, 2),
  (5, 'Venera', 3, 2);

/* Insert data to Seat table */

/* For first train (2 carriages x 6 seats) */
INSERT INTO seat (id, carriage, seat, train_id) VALUES (1, 1, 1, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (2, 1, 2, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (3, 1, 3, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (4, 1, 4, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (5, 1, 5, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (6, 1, 6, 1);

INSERT INTO seat (id, carriage, seat, train_id) VALUES (7, 2, 1, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (8, 2, 2, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (9, 2, 3, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (10, 2, 4, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (11, 2, 5, 1);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (12, 2, 6, 1);

/* For second train (3 carriages x 5 seats) */
INSERT INTO seat (id, carriage, seat, train_id) VALUES (13, 1, 1, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (14, 1, 2, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (15, 1, 3, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (16, 1, 4, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (17, 1, 5, 2);

INSERT INTO seat (id, carriage, seat, train_id) VALUES (18, 2, 1, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (19, 2, 2, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (20, 2, 3, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (21, 2, 4, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (22, 2, 5, 2);

INSERT INTO seat (id, carriage, seat, train_id) VALUES (23, 3, 1, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (24, 3, 2, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (25, 3, 3, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (26, 3, 4, 2);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (27, 3, 5, 2);

/* For third train (2 carriages x 5 seats) */
INSERT INTO seat (id, carriage, seat, train_id) VALUES (28, 1, 1, 3);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (29, 1, 2, 3);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (30, 1, 3, 3);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (31, 1, 4, 3);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (32, 1, 5, 3);

INSERT INTO seat (id, carriage, seat, train_id) VALUES (33, 2, 1, 3);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (34, 2, 2, 3);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (35, 2, 3, 3);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (36, 2, 4, 3);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (37, 2, 5, 3);

/* For fourth train (2 carriages x 6 seats) */
INSERT INTO seat (id, carriage, seat, train_id) VALUES (38, 1, 1, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (39, 1, 2, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (40, 1, 3, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (41, 1, 4, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (42, 1, 5, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (43, 1, 6, 4);

INSERT INTO seat (id, carriage, seat, train_id) VALUES (44, 2, 1, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (45, 2, 2, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (46, 2, 3, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (47, 2, 4, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (48, 2, 5, 4);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (49, 2, 6, 4);

/* For fifth train (2 carriages x 5 seats) */
INSERT INTO seat (id, carriage, seat, train_id) VALUES (50, 1, 1, 5);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (51, 1, 2, 5);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (52, 1, 3, 5);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (53, 1, 4, 5);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (54, 1, 5, 5);

INSERT INTO seat (id, carriage, seat, train_id) VALUES (55, 2, 1, 5);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (56, 2, 2, 5);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (57, 2, 3, 5);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (58, 2, 4, 5);
INSERT INTO seat (id, carriage, seat, train_id) VALUES (59, 2, 5, 5);

/* Insert data to Station table */
INSERT INTO station (id, name, latitude, longitude, state_id) VALUES
  /* Root station - edge of graph */
  (1, 'Finlyandskiy vokzal', 59.9386300, 30.3141300, 3),

  /* Branch #1 */
  (2, 'Novaya Derevniya', 53.059322, 55.097324, 3),
  (3, 'Staraya Derevnya', 55.742793, 37.615401, 3),
  (4, 'Yaztennaya', 59.995899, 30.219865, 3),
  (5, 'Laxta', 60.317238, 32.598541, 3),
  (6, 'Olgino', 47.1879400, 39.9492500, 3),
  (7, 'Lisiy Nos', 60.0168600, 30.0200800, 3),
  (8, 'Gorskaya', 55.742793, 37.6154010, 3),
  (9, 'Alexandrovskaya', 59.7308300, 30.3322200, 3),
  (10, 'Tarxovka', 	60.06687, 29.97435, 3),
  (11, 'Razliv', 	60.07919, 29.97206, 3),
  (12, 'Sestroretsk', 60.09802, 29.96378, 3),
  (13, 'Kurort', 60.11298, 29.95322, 3),

  /* Branch #2 */
  (14, 'Udelnaya', 60.016707, 30.315421, 3),
  (15, 'Ozerki', 60.04446, 30.32986, 3),
  (16, 'Shuvalovo', 60.04552, 30.29223, 3),
  (17, 'Pargalovo', 60.08454, 30.26184, 3),
  (18, 'Levashovo', 60.10369, 30.20683, 3),
  (19, 'Pesochnaya', 60.167061, 29.365217, 3),
  (20, 'Dibuni', 60.12407, 30.12983, 3),
  (21, 'Beloostrov', 60.15118, 30.00151, 3),

  /* Branch #3 */
  (22, 'Piskarevka', 59.99111, 30.41472, 3),
  (23, 'Ruchiy', 	60.00852, 30.46504, 3),
  (24, 'Murino', 	60.0479667, 30.4487408, 3),
  (25, 'Deviatkino', 	60.049799, 30.442248, 3),
  (26, 'Lavriki', 	60.5099, 30.452248, 3),
  (27, 'Kapitolovo', 60.09535, 30.48463, 3),
  (28, 'Kuzmolovo', 60.118539, 30.49769, 3),
  (29, 'Toksovo', 	60.15323, 30.51646, 3),
  (30, 'Kavgolovo', 		60.1818, 30.42622, 3),
  (31, 'Oselki', 		60.248543, 30.451685, 3);

/* Insert into Branch table */
INSERT INTO branch (id, name) VALUES (1, 'Branch #1');
INSERT INTO branch (id, name) VALUES (2, 'Branch #2');
INSERT INTO branch (id, name) VALUES (3, 'Branch #3');

/* Insert into MappingEdge table (mapping graph model) */
INSERT INTO edge (id, station_start_id, station_end_id, branch_id, range_distance) VALUES
  /* Root */
  (1, 1, 2, 1, 10),
  (2, 1, 14, 2, 10.9),
  (3, 1, 22, 3, 7.5),

  /* Branch #1 */
  (4, 2, 3, 1, 3.5),
  (5, 3, 4, 1, 5.4),
  (6, 4, 5, 1, 4.4),
  (7, 5, 6, 1, 6.5),
  (8, 6, 7, 1, 8.7),
  (9, 7, 8, 1, 8.9),
  (10, 8, 9, 1, 3.5),
  (11, 9, 10, 1, 2.7),
  (12, 10, 11, 1, 2.6),
  (13, 11, 12, 1, 3.1),
  (14, 12, 13, 1, 1.4),

  /* Branch #2 */
  (16, 14, 15, 2, 2.5),
  (17, 15, 16, 2, 1),
  (18, 16, 17, 2, 6.5),
  (19, 17, 18, 2, 7.6),
  (20, 18, 19, 2, 7),
  (21, 19, 20, 2, 2.2),
  (22, 20, 21, 2, 9),

  /* Branch #3 */
  (25, 22, 23, 3, 3.2),
  (26, 23, 24, 3, 5.7),
  (27, 24, 25, 3, 0.6),
  (28, 25, 26, 3, 5.7),
  (29, 26, 27, 3, 7.7),
  (30, 27, 28, 3, 2),
  (31, 28, 29, 3, 5.1),
  (32, 29, 30, 3, 9.4),
  (33, 30, 31, 3, 9.1);

/* Insert into Schedule table */
INSERT INTO schedule (id, date_departure, date_arrival, station_departure_id, station_arrival_id, train_id) VALUES
  (1, '2018-09-28 11:00:00', '2018-09-28 20:00:00', 1, 27, 1),
  (2, '2018-09-29 11:00:00', '2018-09-29 19:00:00', 27, 29, 1),
  (3, '2018-09-30 11:00:00', '2018-09-30 14:00:00', 29, 30, 1),
  (4, '2018-10-01 11:00:00', '2018-10-01 16:00:00', 30, 31, 1),

  (5, '2018-09-28 11:00:00', '2018-09-28 20:00:00', 1, 4, 2),
  (6, '2018-09-29 11:00:00', '2018-09-29 13:00:00', 4, 6, 2),
  (7, '2018-09-30 11:00:00', '2018-09-30 14:00:00', 6, 7, 2),
  (8, '2018-10-01 11:00:00', '2018-10-01 19:00:00', 7, 10, 2),
  (9, '2018-10-02 11:00:00', '2018-10-01 20:00:00', 10, 13, 2);

