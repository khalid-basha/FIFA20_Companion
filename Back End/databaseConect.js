exports.databas = async () => {
    var mysql = require ('mysql');

var con = mysql.createConnection({
    host: "localhost",
    user: "yourusername", 
    password: "yourpassword", 
    database: "mydb"
    
  });
}