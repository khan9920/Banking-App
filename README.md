# Banking-App
A project that's being done by 4 SE Students from SLIIT. This project is being built using Java as the backend and good ol' HTML/CSS/JS alongside with JSP and Serverlett

Please read instructions below before submitting or merging your work with this branch.

## Project folder structure

### Database
The database schema has been uploaded to the folder "Database" and you can just download it and import it onto your SQL Database.

### Architecture
This project is using MVC architecture and the view is just laying outside the folders, the model and the controllers are inside the source folder.

**VIEW**
* The view has to be placed inside the WebContent folder.
* It has to be named with lower case and must contain only letters.
* NO numbers can be used in any circumstances.
* You are not allowed to use " . ", " _ " or camelcase when naming view.
* You can use "-" to separate the workds when naming.
* The view must hold .jsp as an extension.

**MODEL**
* The model has to be placed inside the source folder.
* You must use camelcase when naming.
* NO numbers " . ", " _ ", "-" or any other special charactors can be used in any circumstances.

**CONTROL**
* The conrol class has to be placed inside the soure folder.
* You must use camelcase with initial capitalisation when naming.
* NO numbers " . ", " _ ", "-" or any other special charactors can be used in any circumstances.
* You must add "Servlet" at the end of the name in order to keep consistency. (Ex: AddCustomerServlet.java)

**DAO**
* Dao classes has to be placed inside the DAO folder.
* You must use camelcase with initial capitalisation when naming.
* NO numbers " . ", " _ ", "-" or any other special charactors can be used in any circumstances.
* The name of the DAO class and the name of the control class should be same; after dropping the "Servlet" part. (Ex: AddCustomer.java)
