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
   appl.get('/Verify/:password',(req,res)=>{
    let sql = `SELECT *FROM accounts WHERE password =${req.params.password}`;
    let query =db.query(sql,(err,results)=>{
      if(err) throw err ;
      console.log(results);
      res.send(results);
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


module.exports=appl;
