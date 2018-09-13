# RattlerStation
Web-service application

Stack (current): 
  1. Spring 5
  2. Hibernate
  3. JSP
  4. MySQL
  5. Maven
  

`TODO List:`

1. Create use case Diagram [`done`]
2. Create SIMPLE databases: Station, Train, Passenger, Ticket [`done`]
3. Create POJO Entity [`done`]
4. Make correct relations between all tables [`done`]
5. Create Menu JSP [`done`]
6. make sense with REST [`x`]
7. Add a model (graph) of the train map in order to check in the future the validity of creating new schedules [`x`]
8. Create DTO and mapping [`done?`]
9. Create Controller [`done`]
10. Create HTML based JSP, witch views all POJO's [`done`]
11. Add Spring security [`done`]
12. User registration [`x`]
13. Fix form data selection in DAO and controller [`x`]
14. Clean up code in Spring Security config & service classes [`x`]
15. Add `buy ticket` case [`done`]
16. Develop real schedules [`x`]
17. Add many station and develop train map in DB [`x`]
18. Updgrade all cases: log in, ticket traffic, buy tickets [`x`]
19. Add manager functionality [`x`]

My developer dairy:

1. (26.08.18) Set up project, add all dependencies, config `web.xml`, app context (`dispatcherServlet`), create simple controller and write HTML bassed JSP.
2. (27.08.18) Update project name, fix some things.   
3. (28.08.18) Create use-case diagram, start to develop POJO's, create 3 entity-classes: Train, Station, Schedule, set-up relation-ships between them, create tables in DB via Hibernate.
4. (29.08.18) Create DAO (`TrainDAO`, `StationDAO`, `ScheduleDAO`), set up `GenericDAO` and GenericDAO implementation (`GenericDAOImpl`).
5. (30.08.18) Meetup with team curator
6. (1.09.18) Correct tables relationships, create SQL script with DDL.
7. (2.09.18) Create DAO implementation, create hibernate config class, define JSP view stations, create simple controller.
8. (3.09.18) Add bootstrap (but not local), create JSP form for `Actual train traffic` case, create JSP for `Rattler Schedule` case.
9. (4.09.18) Set up Schedule controller, realize 3 mapping methods: for JSP form, for schedule list.
10. (5.09.18) Fix uncorrect HQL query, add alias.
11. (6.09.18) Add Spring security to project, make users autohrization (log in) and admin access.
12. (7.09.18 - 8.09.18) Take a pause. 
13. (9.09.18 - 10.09.18) Create bookig ticket case. Add service, DAO, Entites (Seat and Ticket). Fix DDL, update UserController. Create more JSP pages for booking ticket case.
14. (11.09.18) Create admin functionality for creating new users and select roles (admin, manager or user). Start to develop normal schedules.
15. (12.09.18) Admin can delete users.

16 (13.09.18) Fix bi-directional relation and start working with TrainController for manager case.
