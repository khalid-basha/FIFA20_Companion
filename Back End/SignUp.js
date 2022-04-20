
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
  
  
// insert 

appl.get('/add0',(req,res)=>{
var name = req.query.name;
var pass = req.query.password;
let post={name:name,password:pass};
let sql = 'INSERT INTO accounts SET ?';
let query =db.query(sql,post, (err,result)=>{
  if(err) throw err ;
  console.log(result);
  res.send('account 1 added ...');
     });
});





  module.exports=appl;
