const express = require('express');
const mysql =require('mysql');
const authenticate = require('./authenticate');

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




appl.use(authenticate);

appl.get('/logout',(req,res) => {
    res.redirect('/login/login');
    req.session.destroy();
    
});




module.exports=appl;