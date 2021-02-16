## TEAM Lyrebird 
# Blood Test Diary

# License & Release
The source code is released under a GNU General Public License (GPL), and it's delivered to customer under this free software license.


### Contributors
- Bonian Hu 
- Zhenjie (Jeff) Jiang
- Yilei (Oscar) Liang 
- Tao Lin
- Swapnil Paul
- Yeshvanth Prabakar 
- Patrick Whyte


### Technology Stack
- Spring Boot
- Materializecss

### Language
- HTML/CSS
- JAVA

### Extra stuff required
- An outlook email & secure key(Config at application.properties)
- Google Map API key (Config at hospitals.html)
### How to Setup the Project 
 
- Setup Mysql server, load bloodtestdiary.sql from “bloodTest/src/main/rescources”, in the application.properties, change the mysql information according to the server setup. - Install maven, go into the bloodTest directory, run “mvn clean package” - Using command line, inside the “bloodTest/target”, run “java -jar Lyrebird-0.0.1-SNAPSHOT.java” command line - On any browser(prefer chrome), go to ​http://localhost:8080​, default username is “user” with password “password” 
 
- Main settings of the application, such as: ● MySql database  ● Sender email address Can be found on ​/​bloodTest​/​src​/​main​/​resources​/application.properties
