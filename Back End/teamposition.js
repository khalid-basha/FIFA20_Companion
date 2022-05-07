const express = require('express');
const mysql =require('mysql');
const authenticate = require('./authenticate'); /////  1
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


appl.use(authenticate);///       2

appl.get('/addteam',(req,res)=>{
    
    var email = req.query.email;

    let sql = 'SELECT * FROM teamposition WHERE email =?';
    db.query(sql,[email], function (err, result) {

      if (err) throw err;
      if(result !='')
      {
    
        res.send(result);
    
      } 
      else 
      {
        
        res.json("not found email ");
      }
    
    });
    });




module.exports=appl;