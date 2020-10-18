
# Prework
Implement an createFilm() method that takes a Film object and inserts it into the database. It should return the Film object, or null if the insert fails.

Add an "Add New Film" item to your menu. When this is chosen, prompt the user to input film attributes. For now, don't worry about language (just hardcode the id for 'English' in your DAO code), categories, or actors.

Use the user's input to create a new Film object, passing it to your DAO's createFilm(), then prints the added film.

Modify createFilm() so it retrieves the ID of the newly-inserted film object, and assigns it to the original Film object before returning it.

Make sure your existing Film class and DAO film query methods include film.id in their SELECTs, and include the id as an attribute in the returned Film objects.

Implement deleteFilm() in your DAO that takes a Film as its parameter.

When a film is displayed, the user can choose to delete the film. If they choose this option, the film object is passed to the DAO's deleteFilm.

Test this using films you created using createFilm above - you don't need to be able to delete existing films, which have child records referencing them.
-- Implement a film update operation. - Justin
--- the SQL statement will be on the order of UPDATE <tablename> SET ? (column name) WHERE film.id = ?

# User Story 1
A user can enter a Film's ID and see the details of the film in a web page. If the film is not found, they see an appropriate message.
-- review web.xml - complete
-- review servlet - complete
-- review html - Ashley - create and own index.html
  -- index.html
    -- href=FindFilmById
  --findFilmById.html
    -- input form action"GetFilmById.do"
-- update jsp - Justin
  -- add core library
  -- show film
-- update Controller - Jeanne
  -- @RequestMethods
  -- addObject()


# User Story 2
A user can choose to add a new film. They can enter all the properties of the film. Their input will be used to create Film object, which the DAO implementation will save in the database. If the insert fails, the user is informed of this.

Ashley -- update index.html to have additional link to "AddFilm.html"
Justin -- update jsp
Jeanne -- update Contoller and DAO

# User Story 3
When a user retrieves a film, they have the option of deleting it. If they delete the film, it is removed from the database. If the delete fails (such as, due to child records), the user is informed of this.

Note: It is not necessary to be able to delete existing films, which have child records in various tables. Test your delete functionality using new films you've created via User Story 2.

Ashley - update
Justin - update the show film detail jsp to include a form from deleting the film
Jeanne - update the controller to call the DAO delete method and pass the mv back.

# User Story 4
When a user retrieves a film, they have the option of editing it. If they choose this, all the film's current properties are displayed in a form, allowing them to change any property except the film's ID. When they submit the form, that film's record is updated in the database. If the update fails, the user is informed of this.

Ashley - editFilm.html
Justin - update jsp
Jeanne - update controller to call the DAO update statement

# User Story 5
A user can search for films by keyword/pattern in title or description. From the resulting list of films, the user can choose to update or delete a record.

Ashley - searchFilm.html
Justin - update jsp
Jeanne - update controller to call DAO FindFilmById

# User Story 6
When a film's details are displayed, its actors and categories are also listed.

Justin - update jsp
Jeanne - update controller to show categories and details

# Stretch, stretch goals.
- Create menu in each HTML instead of using back arrow.
