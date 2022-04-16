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
/*
// create tABLE  
appl.get('/creattable',(req,res)=>{
let sql =' CREATE TABLE Accounts (id int AUTO_INCREMENT ,name VARCHAR(255),password VARCHAR(255), PRIMARY KEY(id))';
db.query(sql,(err,result)=>{
  if (err) throw err;
  console.log(result);
  res.send('Accounts table created...');
})

});

*/
// insert 
var namee ='asd';
var passs='123';
/*
appl.get('/add0',(req,res)=>{
let post={name:namee,password:passs};
let sql = 'INSERT INTO Accounts SET ?';
let query =db.query(sql,post, (err,result)=>{
  if(err) throw err ;
  console.log(result);
  res.send('account 1 added ...');
     });
});

*/

// Select  all Accounts
appl.get('/add1',(req,res)=>{
  let sql = 'SELECT *FROM accounts';
  let query =db.query(sql,(err,results)=>{
    if(err) throw err ;
    console.log(results);
    res.send('Done ...');
       });
  });

  // Select  all players
appl.get('/add2',(req,res)=>{
  let sql = 'SELECT *FROM players';
  let query =db.query(sql,(err,results)=>{
    if(err) throw err ;
    console.log(results);
    res.send('Done ...');
       });
  });


   // Select single accounts
appl.get('/add3/:id',(req,res)=>{
  let sql = `SELECT *FROM accounts WHERE id =${req.params.id}`;
  let query =db.query(sql,(err,results)=>{
    if(err) throw err ;
    console.log(results);
    res.send('Done ...');
       });
  });


    // Select single players
appl.get('/add4/:overall',(req,res)=>{
  let sql = `SELECT *FROM players WHERE overall =${req.params.overall}`;
  let query =db.query(sql,(err,results)=>{
    if(err) throw err ;
    console.log(results);
    res.send('Done ...');
       });
  });

 // Update  account
 appl.get('/add5/:id',(req,res)=>{
   let newName='Ashraf Hamayel';
  let sql = `UPDATE accounts SET name ='${newName}' WHERE id =${req.params.id}`;
  let query =db.query(sql,(err,results)=>{
    if(err) throw err ;
    console.log(results);
    res.send('Done ...');
       });
  });

   // Delete  account
 appl.get('/add6/:id',(req,res)=>{
 let sql = `DELETE FROM accounts  WHERE id =${req.params.id}`;
 let query =db.query(sql,(err,results)=>{
   if(err) throw err ;
   console.log(results);
   res.send('Done ...');
      });
 });


appl.listen('3000',()=> 
{
  console.log('server started on port 3000');

});


//}