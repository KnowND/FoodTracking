# Food Tracking project

  Slimming / Trekking System. The client chooses the food (name, proteins, fats, carbohydrates) which he has eaten (from the already completed list) and writes Amount. The customer can add his type of food (name, calorie, proteins, fats, carbohydrates). If the Client has exaggerated the daily norm, the system will inform him about it and write how much Norm has been exceeded.
## Установка и запуск

1. change the configuration of the database /src/main/recoursec/database.properties
2. create tables in the database, find the scripts in the file database.sql
3. Collect a project: open Git Bush enter commands: mvn clean package
4. Run the application: 
  - coppy file target/foodTrackingNew.war to the tomcat/webapps
  - run tomcat tomcat/bin/startup.bat (or startup.sh)
  - optional: set port number in tomcat/conf/server.xml
