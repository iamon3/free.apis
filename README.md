Overview
========

This is my free pizza API server. The API server provides RESTful backend services for the Pizza APP server. To test end- t-end working, boot up APP server instance as well. Please refer to the README at the below mentioned link.

        https://github.com/iamon3/free.pizzaapp

I followed following links for jersey framework + embeded Jetty server integration.

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
    $ export PORT=9090

   To start the Jetty server
   
    $ java -cp target/classes:"target/dependency/*" FreeApiServer
   
   Once the server is started you will see following kind of logs on terminal
   
        $ 2014-08-20 01:52:51.400:INFO:oejs.Server:jetty-7.6.0.v20120127
        $ 2014-08-20 01:52:51.472:INFO:oejsh.ContextHandler:started o.e.j.s.ServletContextHandler{/,null}
        $ 2014-08-20 01:52:51.501:INFO:oejs.AbstractConnector:Started SelectChannelConnector@0.0.0.0:9090      
      
   To test the app locallyTo test the app locally (Following content will be updated soon. Check after few days.)
  
      In the browser Enter the URL : http://localhost:9090/freeapis/pizzas
      
      
   To stop the server 
    
    $ Enter Ctrl+C
    

APIs

    A) Pizza
        GET  /freeapis/pizzas
        POST /freeapis/pizzas
    
    B) Topping
        GET  /freeapis/toppings
        POST /freeapis/toppings
    
    C) User
        POST /freeapis/users    JSON Body {"name":"abc","email":"abc@xyz.com", "password":"xyz"}
        GET  /freeapis/users/authenticate?email=xyz@abc.com&password=xyzabc
        GET  /freeapis/users/{userId}/trnsactions?email=abc@xyz.com
        POST /freeapis/users/{userId}/trnsactions?email=abc@xyz.com  
        
        JSON Body {"timestamp":"123343", "pizzas":[{"name":"Veg", "price":"10", "toppings" : [{"name" : "Cheese"}]}]}
     
    
   

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
