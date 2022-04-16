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

// create tABLE  
appl.get('/creattable',(req,res)=>{
let sql =' CREATE TABLE Accounts (id int AUTO_INCREMENT ,name VARCHAR(255),password VARCHAR(255), PRIMARY KEY(id))';
db.query(sql,(err,result)=>{
  if (err) throw err;
  console.log(result);
  res.send('Accounts table created...');
})

});


// insert 

appl.get('/add0',(req,res)=>{
let post={name:'Ahmad11',password:'123451'};
let sql = 'INSERT INTO Accounts SET ?';
let query =db.query(sql,post, (err,result)=>{
  if(err) throw err ;
  console.log(result);
  res.send('account 1 added ...');
     });
});



appl.listen('3000',()=> 
{
  console.log('server started on port 3000');

});


//}