Overview
========

FIFA World Cup 14 is a simple web application developed using JAVA platform. Following tutorial is followed for the development and deployment of the app.

    https://devcenter.heroku.com/articles/getting-started-with-java

I was facing some web app context path issues in finding the resource index.jsp, in the jetty server context. So the project structure is not in the standard format. I have made it to work. I will work on standardazing the project structure soon. 

index.jsp is the only page which depicts the results. Ajax makes API calls to fetch the data of matches, groups, teams etc. The fetched data which is in JSON format is parsed using javascript JSON and is represented in the tabular format.  As of now, UI is not fancy, and I will work on it later.


A] Project Setup
----------------

   Pre-Requisite
   
     1. Java 1.6 +
     2. git
     3. maven 3 +
      
   To build the project
   
    $ git clone https://github.com/iamon3/FIFA-World-Cup-14.git
    $ mvn clean; mvn package
    $ export PORT=5000

   To start the Jetty server
   
    $ java -cp target/classes:"target/dependency/*" FreeServer
   
   Once the server is started you will see following kind of logs on terminal
   
      $ 2012-01-31 15:51:21.811:INFO:oejs.Server:jetty-7.6.0.v20120127
      $ 2012-01-31 15:51:21.931:INFO:oejsh.ContextHandler:started o.e.j.s.ServletContextHandler{/,null}
      $ 2012-01-31 15:51:21.971:INFO:oejs.AbstractConnector:Started SelectChannelConnector@0.0.0.0:5000
      
      
   To test the app locallyTo test the app locally
  
      In the browser Enter the URL : http://localhost:5000/src/main/webapp/
      
      
   To stop the server 
    
    $ Enter Ctrl+C
   

B] Heroku Deployment Set up
---------------------------

  Pre-Requisite
  
    1. heroku account (Refer : https://signup.heroku.com/signup/dc)
    2. heroku toolbelt 
    
  Setting up and deploying app in Heroku (Refer : https://devcenter.heroku.com/articles/getting-started-with-java)
  
     $ heroku login
     $ Push the project on git
     $ heroku create
     $ git push heroku master
     
   The demo of the deployed running web app "The FIFA World Cup 14" can be tested at the below mentioned link. 

      http://salty-chamber-4774.herokuapp.com/src/main/webapp/

   Please note that in the case of no activity for some time period (e.g. 1hr), web app will go in idle state, in which case    the next URL access may result in the slower response or 404. 
