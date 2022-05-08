const express = require('express');
const authenticate = require('./BusinessLayer/authenticate'); /////  1
const db = require('./BusinessLayer/databaseConect').db;


const appl=express.Router();


appl.use(authenticate);///       2

appl.get('/addteam',(req,res)=>{
    
   

    let sql = 'SELECT * FROM teamposition WHERE email =?';
    db.query(sql,[req.session.user], function (err, result) {

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