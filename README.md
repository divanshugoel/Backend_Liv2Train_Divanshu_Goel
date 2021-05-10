# Student-Training-Centre-Locator

Student-Training-Centre-Locator is a Spring Boot (version 2.4.5) application that can add student training centres. It also helps to view the details of all added student training centres till now.



## How To Run

* Clone this repository.
* Create a database in MySql using the following commands
```
   CREATE DATABASE training_centre_db;
   commit;
```
* Run the above commands in MySQL Workbench.
* You can build the project by using the following command  
```
   mvn clean install
```
* Once successfully built, you can run the application by the following command
```
2021-05-10 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2021-05-10 17:31:23.097  INFO 19387 --- [           main] org.liv2train.app.student.training.centre.locator.StudentTrainingCentreLocatorApplication        : Started Application in 22.285 seconds (JVM running for 23.032)
```

* REST APIs can be accessed over the following base-path :

     ```http://localhost:8080/api/trainingcentre```

* Some of the important api endpoints are as follows :
 
  * ```http://localhost:8080/api/trainingcentre/save (HTTP:POST)```
  * ```http://localhost:8080/api/trainingcentre/all (HTTP:GET)```

## API Specs
The API Specifications are as follows- 
### Create a training centre resource
``` 
curl --location --request POST 'http://localhost:8080/api/trainingcentre/save' \
--header 'Content-Type: application/json' \
--data-raw '{
    "centreName": "A",
    "centreCode": "Aa123456789A",
    "studentCapacity": 10,
    "email": "Aa@gmail.com",
    "phoneNumber": "9823145601",
    "coursesOfferd": [
        "a",
        "b",
        "c"
    ],
    "address": {
        "detailedAddress": "abc",
        "city": "A",
        "state": "b",
        "pincode": "1234"
    }
}'
```
### Retrieve all training centres
```
curl --location --request GET 'http://localhost:8080/api/trainingcentre/all'
```
## Contact



Project Link: [https://https://github.com/divanshugoel/Backend_Liv2Train_Divanshu_Goel](https://https://github.com/divanshugoel/Backend_Liv2Train_Divanshu_Goel)
