//exports.databas = async () => {

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
const appl=express();
appl.listen('3000',()=> {
  console.log('server started on port 3000');

});




//}