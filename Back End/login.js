//  ---------each login will be inserted like this 

const express = require('express');
const mysql =require('mysql');
// Creat Connection 
const db = mysql.createConnection ({
  host: "localhost",
  user: "root", 
   password:"", 
  database: "fifa"  
});
// conect 
db.connect( (err)=>{
if (err){throw err;}
console.log('MySql Connected ...');
});
const appl=express.Router();




   // Verify login information (name and password)
   appl.get('/as',(req,res)=>{

    var name = req.query.name;
var pass = req.query.password;
var sql = 'SELECT * FROM accounts WHERE name =? and password =?';
db.query(sql, [name, pass], function (err, result) {

  if (err) throw err;
  if(result){
    console.log(result);
    res.send(result);
  }else{
    res.json("not found ")

    

 }
});
    });
  //Query a Database

//   con.connect(function(err) {
//     if (err) throw err;
//     console.log("Connected!");
//     con.query(sql, function (err, result) {
//       if (err) throw err;
//       console.log("Result: " + result);
//     });
//   });


module.exports=appl;
