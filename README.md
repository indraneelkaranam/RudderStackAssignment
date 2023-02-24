# RudderStack
## Assignment for interview

![alt text](https://drive.google.com/uc?export=view&id=1tpRJQ1nVTGhqKS5XsUxsHQAdH0l0rrM0)

## Admin
Admin can add the source templates to DB through the swagger UI provided 
## User
- User needs to select the source type for the form to be loaded
- User can fill the form data and data will be persisted
- Responses can be changed user at any time

## Set Up 

### server
- The set up is simple for this, Start the Spring Boot server and it will start running on localhost:8080
- The admin can add sources through swagger UI provided! It can be accessed at `localhost:8080/swagger-ui.html#/`

### UI
UI can be started thrown following steps
```sh
cd UI
npm install
npm start
```
npm start will open up UI in localhost:3000, start filling the forms for specific user using link `localhost:3000?userId=<random string>`

userId is to mention the specific user filling of forms

## TechStack Used

- Java and Spring Boot for Server
- React Js for UI
