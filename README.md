Pizza APIs Overview
===================

This is the API server for the Pizza application. The API server provides RESTful backend APIs for the Pizza APP server. To test the end-to-end working, boot up the APP server instance along with the API server. Please refer to the README at the below mentioned link for the APP server set up and boot up.

        https://github.com/iamon3/free.pizzaapp

I have followed the blogs at the below mentioned links for the jersey framework & embeded Jetty server integration.

    https://devcenter.heroku.com/articles/getting-started-with-java
    http://www.tzehon.com/2012/11/06/microservices-with-jetty-and-jersey/


A] Project Setup
----------------

   Pre-Requisite
   
     1. Java 1.6 +
     2. git
     3. maven 3 +
      
   A]  Set up the API server on a sandbox
   
   1) Clone the repository
   
    $ git clone https://github.com/iamon3/free.apis.git

   2) Configure the APP server end-point in the src/main/java/FreeApiServer.java file . You need to update the property as shown.

    e.g private static String ALLOWED_ORIGINS = "http://localhost:8080,http://foo.com"; // comma separated allowed origins

   3) Build the API server
    
    $ mvn clean; mvn package
    $ export PORT=9090         // Port for API server.

   4) Boot up the API server
   
    $ java -cp target/classes:"target/dependency/*" FreeApiServer
    
   5) Set up and Boot up the APP server. Refer
   
    https://github.com/iamon3/free.pizzaapp
   
   Following kind of logs are displayed when the API server boots up.
   
        $ 2014-08-20 01:52:51.400:INFO:oejs.Server:jetty-7.6.0.v20120127
        $ 2014-08-20 01:52:51.472:INFO:oejsh.ContextHandler:started o.e.j.s.ServletContextHandler{/,null}
        $ 2014-08-20 01:52:51.501:INFO:oejs.AbstractConnector:Started SelectChannelConnector@0.0.0.0:9090      
      
   6) APIs can be tested against an HTTP request in the required format. e.g. CURL can be used for the same as below.
  
       curl -i -H "Accept:application/json" http://localhost:9090/freeapis/pizzas
      
      
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

      http://free-pizza-apis.herokuapp.com

   e.g. APIs will be as

     http://free-pizza-apis.herokuapp.com/freeapis/pizzas
     http://free-pizza-apis.herokuapp.com/freeapis/toppings

   Please note that in the case of no activity for some time period (e.g. 1hr), web app will go in idle state, in which case    the next URL access may result in the slower response or 404. 
