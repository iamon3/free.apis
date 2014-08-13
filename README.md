Overview
========

This is my free sample API server. I followed following links for jersey framework + embeded Jetty server integration.

    https://devcenter.heroku.com/articles/getting-started-with-java
    http://www.tzehon.com/2012/11/06/microservices-with-jetty-and-jersey/


A] Project Setup
----------------

   Pre-Requisite
   
     1. Java 1.6 +
     2. git
     3. maven 3 +
      
   To build the project
   
    $ git clone https://github.com/iamon3/free.apis.git
    $ mvn clean; mvn package
    $ export PORT=5000

   To start the Jetty server
   
    $ java -cp target/classes:"target/dependency/*" FreeServer
   
   Once the server is started you will see following kind of logs on terminal
   
      $ 2012-01-31 15:51:21.811:INFO:oejs.Server:jetty-7.6.0.v20120127
      $ 2012-01-31 15:51:21.931:INFO:oejsh.ContextHandler:started o.e.j.s.ServletContextHandler{/,null}
      $ 2012-01-31 15:51:21.971:INFO:oejs.AbstractConnector:Started SelectChannelConnector@0.0.0.0:5000
      
      
   To test the app locallyTo test the app locally (Following content will be updated soon. Check after few days.)
  
      In the browser Enter the URL : http://localhost:5000/freeapis/services/*
      
      
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
     
   The demo of the deployed running free API server "freeapis" can be tested at the below mentioned link. 

      http://foo.com/v1        (Will be updated soon)

   Please note that in the case of no activity for some time period (e.g. 1hr), web app will go in idle state, in which case    the next URL access may result in the slower response or 404. 
