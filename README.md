# AuctionBidTracker

This project is a basic implementation of auction bid tracker system where a user can bid on items created by the admin to win.
This project is the backend implementation of the project in technologies such as SpringBoot, SpringData JPA, MySql etc,.

Main implementations in this project are:-
1) Create an Item.
2) Create User.
3) Bid on an item in auction.
4) Get List of bids on an item. 
5) Get List of Items on which a user has bid on.
6) Create or Save bid on an item by the user.

The API's can be seen or tested on the swagger documentation of the project which can be accessed on the url given below:

```
http://localhost:8080/swagger-ui.html
```

To test these API's in Postman a json file by the name------is created in it.
Just open that file in Postman and you will be able to test all the API's when the server is running.

### Steps to use this project
1) After cloning the project from git create a database with name "auctionBidTrackerDB".
2) Change the MySql username and password in application.properties file according to your system.
3) Start the project as a SpringBoot Application. By doing this the tables will be created in your database and the server will be up and running.
4) Now take the AuctionBidTrackerAPIs.postman_collection.json file present in the project and open it in Postman and start using/hitting these API's in the sequence as mentioned below:
    1) Create Users using "Create User" API in Postman.
    2) Create Item using "CreateItem" API in postman.
    3) Bid on items for auction using "Create/Save Bid" API for different users on the same itemId/item.
    4) Get the details of winning bid from its respective API in Postman.
    5) Get List of bids on an item fro its respective API in Postman.
    6) Get List of items a user has bid on by using its respective API in Postman. 

