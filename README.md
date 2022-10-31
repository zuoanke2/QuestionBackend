# QuestionBackend
## Build and run the project
### Pull the code
You already done that
### install the DB
1, install MySql follow the tutorial (https://dev.mysql.com/doc/mysql-installation-excerpt/5.7/en/).  
2, I recommend you to use some GUI DB tool like Navicat.  
3, excute the test.sql file by any DB management tool you like, I use Navicat.  
4, after that, my database shoule been copied on your local computer.  
5, my DB account name is root, my password is 123456. You could set the same account and password like mine so you don't need to modify anything of the project file.  
6, run your DB.
### Open and run with IDE, take IDEA as an example (I highly recommend you to use IntelliJ IDEA!!!)
1, open IDEA, click the Open button.  
2, select the pom.xml file in the project folder, and click the Open as Project button.  
3, my database port is 3306, and my database name is test, if you set these the same with mine, you don't need to modify anything of the project files.  
4, otherwise, please modify these parameters in the application.yml file in the resources folder.  
5, IDEA has already integrated maven, so you don't need any configuration, just wait for maven automatically grab every library this project need.  
6, when maven finish its job, just click the Run button of green color on the top bar of the window and it will run the DemoApplication.  
7, now I beileve the backend service is running on 8080 port.  
## Backend Service
### How to send request (I recommend you to use Postman to send test requests)
1, I assume there are 5 users, id from 1 to 5. Every user access different site, will get a set of questions with unique order. And each site has its unique set of questions.  
2, as an user, to get your question, send a post request by call localhost:8080/contents/get, the request body should be like the picture below:  
<img width="527" alt="image" src="https://user-images.githubusercontent.com/117051280/198933651-2452c86f-70af-471b-a176-5fd0d7722bf2.png"><br>
userId means your own id, siteId means which site you are accessing, after you called it, the backend will return you the question content json like the picture below:  
<img width="535" alt="image" src="https://user-images.githubusercontent.com/117051280/198934617-c147e259-58fc-40c8-8435-9c25f41778a7.png"><br>
3, if you answer a question, you need call localhost:8080/Answer with your frontend interface or Postman, the post request include the request body like the picture below:  
<img width="644" alt="image" src="https://user-images.githubusercontent.com/117051280/198934342-41fe5e26-baa4-4b37-9266-e413063eab8b.png"><br>
the optionText means the text of selection, userId means your id, qId means the id of current question, type means the type of this question. Just let the result to be blank.  
note you can find all of these data like qid or type from the returning of step2.   
After you answered the question, if the question is quiz type, the backend will calculate and return the frequencies of each option of the question, like picture below:  
<img width="246" alt="image" src="https://user-images.githubusercontent.com/117051280/198935270-f64427e0-7162-46e7-880a-2a8d1b854567.png"><br>
the result means weather your selection meet the correct answer.  
4, there are some other API, localhost:8080/questions/get can return you the list of all questions. localhost:8080/siteInfo/get can return you the question list of every site (qid means question id):  
5, all your answer will be record in the answer table of the database and will be counted when you answer the quiz question.  
## Other comments
### security
In my project, because the limitation of time, I haven't implemente any security mechanism, I just use post request to avoid exposing the data to URLs.  
But if it is a commercial project, it should have SSO login and token verification, also it should use cookies to handle user data.  
The most important, the data in database shoule been encrypted by something like Jasypt.  
### future scale
1, the security mechanism is needed as I mention in the security chapter.  
2, if the user scale increases to million-level, the database sharding is needed, and you might also need to deploy the service on distributed system.  
3, if there are some other kind of widget not only the embed item, the Microservice might be a good attempt.   
