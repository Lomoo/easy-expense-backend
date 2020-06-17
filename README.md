# Easy Expense is meant to be a lightweight, easy-to-use and straight forward expense tracker.

## To see easy expense head to our heroku deployment: https://easy-expense-client.herokuapp.com/


## Client

Easy expense uses reactJS with various libraries to store and display the users data. 

### React Hooks
The goal of this project was to become familiar with react hooks such as useState, useReducer etc. useContext was used as a global state manager, as opposed to Redux, due to the simplicity of the project.

### User Authentication
User's are authenticated using AWS coginito and AWS amplify. All user data is handled by AWS, and user data is not stored on our servers. 

User's can sign up with their email, or use Oauth and sign in with their Google Accounts.

### UI And Styling
The Bulma CSS framework is used in conjunction with styled components to deliver most of the UI.

## Server
Easy Expense utlized Spring Boot as it's server.

### API
Spring Boot and JPA were utilized to create an API, and store/retrieve user data from a Postgres database. Initially, AWS RDS was used to store user data. However in order to deploy without accruing cost, Heroku was adopted half-way through development. 

### Deployment 
Easy expense uses Heroku to deploy. 
