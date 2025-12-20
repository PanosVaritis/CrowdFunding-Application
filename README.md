# Crowdfunding Web App

## Installation

Clone the repository
```
git clone https://github.com/PanosVaritis/CrowdFunding-Application.git
```

## Features

-   **Admin User**: An admin user is automatically created. The admin can view new users who sign up in the system and approves the registration. Also admin can view all project that users post and approves them. Οnly the approved project is displayed.

-   **Unique Usernames**: The app does not allow users to register with the same username. If a username already exists, registration is prevented.
-   **User Enablement**: The admin can enable or disable users. Only enabled users can log in to the app.


## Database: Fix the database connection
Create a .env file in the root of the project with the fields shown below
```bash
export POSTGRES_USER=you_user
export POSTGRES_PASSWORD=your_password
export POSTGRES_DB=your_databse
```
Add the same credentials in the application properties file
```bash
spring.datasource.url=jdbc:postgresql://postgres:5432/your_database
spring.datasource.username=your_user
spring.datasource.password=your_password
```
Check the database (Make sure no other service is running in port 5432)
```bash
psql -h localhost -U your_user -d your_base -W
```
Execute queries in the base
```bash
\dt
```
```bash 
SELECT * FROM users;
```

## Run the application
Make sure no other volume with the same names exists (as the one in the compose)
```bash
docker compose up --build
```
Stop the app and clear all the base (To keep the data ommit the -v param)
```bash
docker compose down -v
```

## Run jenkins pipeline (Optional- Requires parameterization)
#### No one can actuallly run the pipeline because my credentials -git hub username and token- are used and cannot be paramameterized. But if someone could take the code and altered it using its own credentials, could follow a similar procedure as described below to run the pipeline

1. Install jenkins in a vm -check the official documentation to see how- or go to the repo bellow and run the compose file as instructed in the readme file of the repository
```bash
git clone https://github.com/PanosVaritis/jenkins-container-with-docker.git
```
2. Create a new item (provide a name of your liking), select to have a pipeline and then configure it as described
    - Definition -> Pipeline from SCM 
    - SCM -> git
    - Repository URL -> paste this :  https://github.com/PanosVaritis/CrowdFunding-Application.git (No need for credentials - it is a public url)
    - Branches to build -> /jenkins
    - Script Path -> Jenkinsfile.dev
    - Save (You can also set a poll scm from the trigger section but this requires to have the jenkins server always up)

3. The pipeline builds and pushes an image to a container registry (in this scenario git hub, but any should do), so credentials are required (Use your git hub username, and upload a personal access token created from your account)
    - Manage jenkins -> Credentials -> Global credentials -> Secret text (paste the token you have created from your account). The id you will provide should match the one used inside the pipeline

4. If you want to have the post actions you must configure the smtp server in jenkins, otherwise comment out the part of the code with the post actions
    - Create from your mail account an app password and upload it as a global credential "Username with Password", were username is the email address and password the app password you have issued and id whatever you want
    - Jenkins Location -> Sys admin email address -> someone@mail.com -This will be the from email address-
    - Extended email notification: -you can omit this and go directly to the email notification-
        - Smtp server: if you have gmail as provider you should use: smtp.gmail.com -eitherwise find your provider from the web. The smtp server you will type here should match the one in the "from" email address
        - Select smtp port 587, from the advanced section below select the credential you have created, and TLS for security (or 465 port and SSL)
    - Down in the end of the configuration find : Email - Notification
        - SMTP server: the same with the one used above
        - Advanced -> TLS (587) or SSL (465). Should be the same as the one used above
        - SMTP auth -> username: your email, and password the app password you have issued 
        - You can check the configuration by sending a test mail
