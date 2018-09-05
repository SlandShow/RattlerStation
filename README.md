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
8. Create DTO and mapping [`x`]
9. Create Controller [`done`]
10. Create HTML based JSP, witch views all POJO's [`done`]
11. Add Spring security [`x`]
12. User registration [`x`]
13. Fix form data selection in DAO and controller [`x`]

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
