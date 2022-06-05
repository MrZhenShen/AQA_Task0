# Tasks

### maven code for main method execution

``
mvn clean install exec:java -Dexec.mainClass="tasks.task_5.stream.DispatcherTaskStream" -Dexec.args="arg0 arg1"
``

### task_9

[Google Docs](https://docs.google.com/document/d/1-yvU42hdwVt_eXKsQPIGsN-Ws3O91eBYqgjiBnpewEU/edit?usp=sharing)

### task_14 - allure report run

``
mvn clean test
``

``
allure serve -h localhost
``

### task_10, task_11, task_12, task_13

Before run tests type in [DuolingoCredentials.java](src/main/java/credentials/DuolingoCredentials.java) your Duolingo
login and password

### task_16, task_17
Before run tests get API Key and Token from [Trello API](https://trello.com/app-key) and paste them into [TrelloCredentials.java](src/main/java/credentials/TrelloCredentials.java)

# Test Framework

In order to run all test

``
mvn test
``

### Unsplash API

1. Copy Access and Security from https://unsplash.com/developers and paste each accordingly
   into [credentials.txt](credentials.txt)
2. In Redirect URI & Permissions section copy Authorization code and paste into AUTH_CODE
3. To run framework in project terminal type following code:

``
mvn test -Dtest="UnsplashTest" -DcredId=0 -DauthCode={code}
``

### Duolingo UI

1. Type your Duolingo login and password into [credentials.txt](credentials.txt)
2. In [Google cloud](https://console.cloud.google.com/home/dashboard) create new project
3. Type in terminal following code

``
gcloud auth activate-service-account {service account email} --key-file="{project .json file with google cloud credentials}" --project={google cloud project title}
``

3. To run framework in project terminal type following code:

``
mvn test -Dtest="DuolingoTest" -Dgoal=Basic -Dskill="Basics 1" -DcredId=0
``