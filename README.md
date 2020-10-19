## Spring MVC Film C.R.U.D. Week 8 Project

### First Group Project (Justin, Jeanne, Ashley Davis).

### Overview
This was our first team project of the course. We worked as a team of 3 to complete our first Spring MVC C.R.U.D. Project.

One teammate will own the Github repository that the other teammates copied and will also be able to push and pull from.

## Usage
This project allows the user to access a mySQL database of films.

The user can enter a film and see details about that film in a web page.

<img src="https://github.com/JustLivingg/SpringMVCFilmCRUD/issues/1#issue-724483678"/>

The user can also add films to the database, edit existing records, and delete films they added from the database.

The user is also able to search for films by keyword. From there, they can choose to edit, delete a film, or return to the main menu.

<img src= https://github.com/JustLivingg/SpringMVCFilmCRUD/issues/3#issue-724490157 />

### Lessons Learned
I can be the first to say (Justin) that this project gave us a run for our money. We encountered a lot of issues, some ranging from fixing our Githubs, pushing and pulling Github requests. There were many times in our code where we couldn't figure out what was wrong with our code. Not sure if the controller was wrong, or if the DAO was wrong.

As a team we were able to find film by ID and find film by search, but we had the hardest time adding a film to the database. After long hours we finally figured it out and we weren't mapping the correct fields from our HTML to the JSP. There are little mistakes that you search for that throw you for a loop. Even after diagnosing and creating sysouts in our code to find out where our code was breaking were we able to finally put together and add film to database.

Jeanne also taught us a valuable lesson and created a film site plan for us. Her experience as a program manager helped divide tasks to make the project smoother so none of us were stepping on eachothers toes.

## Development 
User can enter a film and see the results displayed on a web page.

<img src= https://github.com/JustLivingg/SpringMVCFilmCRUD/issues/5#issue-724495612 />

User can choose to add a new film and enter all properties of the film. Our DAO implementation then saves this information to the database. User also has the option to delete films they added from the database. User can search films from the database by keyword, then update or delete from the resulting list.


## Known Bugs
Features associated with User Story 4 and 6 are still in production. 
There is an error on mapping the JSP to the HTML film and getting the values of the HTML file and SQL to match.


## What we used in this Project
- SPRING MVC
- Gradle
- Apache Tomcat 8.5
- MYSQL
- HTML
- Github
- JSP
- XMP
- SERVLETS

### How to run.
You must compile the code and run on server. Current version will only work on the console of Spring Tool Suite. Once you download the zip file and import project onto your IDE you will run on server. From there you will choose 3 menu items from selecting a film by ID, search text, or entering a new film.
