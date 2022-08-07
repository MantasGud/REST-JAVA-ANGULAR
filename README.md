# REST-JAVA-ANGULAR
## **Java 8 + Angular 14 REST Task**

Simple REST services project 

Application server side runs at **http://localhost:8080** , client side **http://localhost:4200**.


### **Rest procedures**

- **GET** customers/ - full customers list
- **GET** customers/{id} - info about one customer
- **POST** customers/ - create new customer
- **PUT** customers/{id} - updates specific customer
- **DELETE** customers/{id} - deletes specific customer

To create new customer or update it json example - 
{
"name":"DDD",
"surname":"444",
"telNumber":"861111111",
"email":"aaa@ffff.com",
"birthDate":"2022/05/01"
}

### **How to run**

**Server side** 
- Clone this repository
- Open project with IDE (I used **ECLIPSE**)
- Update project thru **MAVEN**
- Run **SpringAppStart.java** as **JAVA Application**

Application running at http://localhost:8080

**Client side**

- Make sure **ANGULAR** is installed in the system
- In CMD go to client side project folder and run commmand **ng serve**


Application running at http://localhost:4200
