
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
    
    

  appl.get('/find',(req,res)=>{
    
    var lName = '%'+req.query.lName+'%';
    var overallMin = req.query.overall;
    var overallMax = req.query.overall;
    var ageMin = req.query.age;
    var ageMax = req.query.age;
    var position = '%'+req.query.position+'%';

    let sql = 'SELECT * FROM players WHERE Lname like ? AND overall BETWEEN ? AND ? AND age BETWEEN ? AND ? AND position like ?';
    db.query(sql,[lName, overallMin, overallMax, ageMin, ageMax, position], function (err, result) {

      if (err) throw err;
      if(result !=''){
    
        res.send(result);
    
      } 
      else 
      {
        
        res.json("not found players ");
      }
    
    });
    });



module.exports=appl;