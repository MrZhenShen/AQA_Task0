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

### Unsplash API

1. Cope Access and Security from https://unsplash.com/developers and paste into each accordingly
   in [UnsplashCredentials.java](src/main/java/testFramework/credentials/UnsplashCredentials.java)
2. In Redirect URI & Permissions section cope Authorization code and paste into AUTH_CODE
3. To run framework in project terminal type following code:

``
mvn -P UnsplashTest test
``
