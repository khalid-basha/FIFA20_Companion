var mysql = require ('mysql');

var con = mysql.createConnection({
    host: "localhost",
    user: "yourusername", 
    password: "yourpassword", 
    database: "mydb"
  });


  // each login will be inserted like this 
  
  con.connect(function(err) {
    if (err) throw err;
    console.log("Connected!");
    var sql = "INSERT INTO Account (name, password) VALUES ('Ahmad', '12345')";
  con.query(sql, function (err, result) {
    if (err) throw err;
    console.log("1 record inserted");
  });
  });

  //to run it tyoe in terminal ("node login.js")

  //Query a Database

//   con.connect(function(err) {
//     if (err) throw err;
//     console.log("Connected!");
//     con.query(sql, function (err, result) {
//       if (err) throw err;
//       console.log("Result: " + result);
//     });
//   });