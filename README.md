Run the class `LibraryManagementSystemMain.java`     
is important to create the database and use PostgresSQL, in this case I used PostgresSQL, so I created a database in `/localhost:5432/book`, change the port or database if you want.  

With the root `/api/books` you can use the next endpoints:  
-`/{id}` `Get book by Id` , `Put by Id` or `Delete By id`  
- Using `/api/books` you also can add new book,

### Example of book:  
`{
  "title": "Risitos de oro",
  "author": "Desconocido",
   "isbn " : "I7UEU",
   "publishedDate": "1998-03-09"
} ` 


  
