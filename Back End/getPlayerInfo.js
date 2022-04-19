
  // this is used to get the information needed for the player 
  //(name , age ,position , price ... etc)

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

  // Select palyers dpending on part of their name
  appl.get('/add2',(req,res)=>{
    let sql = 'SELECT *FROM players WHERE Lname like "%PartOfTheName%"';
    let query =db.query(sql,(err,results)=>{
      if(err) throw err ;
      console.log(results);
      res.send('Done ...');
         });
    });



module.exports=appl;