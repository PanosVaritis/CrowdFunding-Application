# Crowdfunding Web App

## Installation

Clone the repository
```
git clone https://github.com/PanosVaritis/CrowdFunding-Application.git
```
## Usage
Check the database
```bash
\dt
```
Get all users from users table 
```bash
SELECT * FROM users;
```
## Features

-   **Admin User**: An admin user is automatically created. The admin can view new users who sign up in the system and approves the registration. Also admin can view all project that users post and approves them. Οnly the approved project is displayed.

-   **Unique Usernames**: The app does not allow users to register with the same username. If a username already exists, registration is prevented.
-   **User Enablement**: The admin can enable or disable users. Only enabled users can log in to the app.


## Technologies
-   Java 21
-   Maven 3.9.9

## Database: Fix the database connection
Create a .env file in the root of the project with the fields shown below
```bash
export POSTGRES_USER=you_username
export POSTGRES_PASSWORD=your_password
export POSTGRES_DB=your_databse
```
Add the same credentials in the application properties file
```bash
spring.datasource.url=jdbc:postgresql://postgres:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```
