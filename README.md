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
4. Make correct relations between tables [`x`]
5. add a model (graph) of the train map in order to check in the future the validity of creating new schedules [`x`]
6. Change entity relationships in `Schedule` class to `Many-to-One` [`x`]
7. Create DTO and mapping [`x`]
8. Create Controller [`x`]
9. Create HTML based JSP, witch views all POJO's [`x`]

##My developer dairy:

1. (26.08.18) Set up project, add all dependencies, config `web.xml`, app context (`dispatcherServlet`), create simple controller and write HTML bassed JSP.
2. (27.08.18) Update project name, fix some things.   
3. (28.08.18) Create use-case diagram, start to develop POJO's, create 3 entity-classes: Train, Station, Schedule, set-up relation-ships between them, create tables in DB via Hibernate.
4. (29.08.18) Create DAO (`TrainDAO`, `StationDAO`, `ScheduleDAO`), set up `GenericDAO` and GenericDAO implementation (`GenericDAOImpl`).
5. (30.08.18) Meetup with team curator
