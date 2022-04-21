
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
    var Lname = req.query.Lname;

    let sql = 'SELECT *FROM players WHERE Lname  LIKE  "%?%" ';
    db.query(sql,[Lname], function (err, result) {

      if (err) throw err;
      if(result){
    
        console.log(result);
        res.send(result);
    
      } 
      else 
      {
        
        res.json("not found ");
      }
    
    });
    });



module.exports=appl;