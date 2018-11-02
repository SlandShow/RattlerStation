# RattlerStation 🚄
Web-service application

### Stack (current): 
  1. Spring 5
  2. Hibernate
  3. JSP
  4. MySQL
  5. Maven
  6. RabbitMQ broker

## Info ☕
🚉 [RattlerStation Board](https://github.com/SlandShow/RattlerStationBoard "RattlerStation Board") → show schedulers for today, dynamic update schedulers via `AJAX`.

🚩[Full-module zip](https://www.dropbox.com/s/a4k8smrqxzjiewx/Multimodule.zip?dl=0 "RattlerStation multimodule").

## Dev 🛠️

### Configuration:
1. [Install Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html "Maven") 🍭
2. [Install & Config Tomcat](https://www.baeldung.com/tomcat "Tomcat") 🌵
3. [Install & Config MySQL server](https://www.javacodegeeks.com/2018/05/mysql-server-tutorial.html "MySQL") 🍦
4. [Install RabbitMQ broker on Linux (or another OS) guide](https://www.vultr.com/docs/how-to-install-rabbitmq-on-ubuntu-16-04-47 "RabbitMQ") 💬
5. [Sonar install & config guide (+ info)](https://www.baeldung.com/sonar-qube "SonarQube") 📈
6. [Google Maps API documentation (+ info)](https://developers.google.com/maps/documentation/ "Google maps API") 🗺

### Run:
1. Run Tomcat (`.../bin/startup.sh`)
2. Run Wildfly 
3. Run `init.sql`
4. Run 'insert.sql`
5. Run cargo-plugin `mvn clean package org.codehaus.cargo:cargo-maven2-plugin:redeploy`

### ☑ TODO List:

1. Create use case Diagram [`done`]
2. Create SIMPLE databases: Station, Train, Passenger, Ticket [`done`]
3. Create POJO Entity [`done`]
4. Make correct relations between all tables [`done`]
5. Create Menu JSP [`done`]
6. Make sense with REST [`done`]
7. Add a model (graph) of the train map in order to check in the future the validity of creating new schedules [`done`]
8. Create DTO and mapping [`done`]
9. Create Controller [`done`]
10. Create HTML based JSP, witch views all POJO's [`done`]
11. Add Spring security [`done`]
12. User registration [`done`]
13. Fix form data selection in DAO and controller [`done`]
14. Clean up code in Spring Security config & service classes [`done`]
15. Add `buy ticket` case [`done`]
16. Develop real schedules [`done`]
17. Add many station and develop train map in DB [`done`]
18. Updgrade all cases: log in, ticket traffic, buy tickets [`done`]
19. Add manager functionality [`done`]
20. Create graph mapping to graph object [`done`]
21. Schedule validation via map and graph model [`done`]
22. Add Google maps API [`done`]
23. Add price calculation [`done`].
24. Ann Unit-test's and Sonar [`done`].

### 📘 My developer dairy:

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
17. (14.09.18 - 27.09.18) Add a lot of things and work with user-deirndly interface. Add manager, add normal booking ticket case, confirm first review.
18. (08.10.18) Set-up WildFly server, create second application, download and setiup RabbitMQ broker. Create service to send messages from RattlerStation app to second app.

19. (08.10.18) Create graph model (tables and Graph service).
20. (13.10.18) Add REST-controller, create second app, make sense with AJAX. Get today schedule from first app to second.
21. (23.10.18) Add Sonar, fix searching via graph system (actual train traffic case), add google maps, update booking tickets search page.

22 (28.10.18) Clean all code, chech all use-cases, fix schedule puzzling and ticket booking, create unit-test, add more navigation on front.
