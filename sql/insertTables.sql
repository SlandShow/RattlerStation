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

/* Insert data to Role table */
INSERT INTO role (id, type) VALUES (1, 'ROLE_USER');
INSERT INTO role (id, type) VALUES (2, 'ROLE_ADMIN');

/* Insert data to User role table */
INSERT INTO user_role (user_id, role_id) VALUES (1, 2);