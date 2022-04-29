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
if (err){
  throw err;
}
console.log('MySql Connected ...');

});
const appl=express.Router();






appl.get('/logout',(req,res) => {
    req.session.destroy();
    res.redirect('/');
});




module.exports=appl;