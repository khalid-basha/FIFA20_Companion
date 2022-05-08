

const express = require('express');
const authenticate = require('../BusinessLayer/authenticate'); /////  1
const db = require('../BusinessLayer/databaseConect').db;


const appl=express.Router();


appl.use(authenticate);///       2

appl.get('/addteam',(req,res)=>{

  var GK = '%'+req.query.GK+'%';
  var LB='%'+req.query.LB+'%';
  var CB1='%'+req.query.CB1+'%';
  var CB2='%'+req.query.CB2+'%';
  var RB='%'+req.query.RB+'%';
  var DM='%'+req.query.DM+'%';
  var CM1='%'+req.query.CM1+'%';
  var CM2='%'+req.query.CM2+'%';

  var LW='%'+req.query.LW+'%';

  var CF='%'+req.query.CF+'%';

  var RW='%'+req.query.RW+'%';


  var ema=req.session.user;
    let sql = 'SELECT * FROM teamposition WHERE email =?';
    db.query(sql,[ema], function (err, result) {

      if (err) throw err;

      if(result !='')
      {
     
       /////////////////    GK  //////////////////////////////////
        let GKs = "SELECT * FROM players WHERE lName like ? and position = 'GK' and available ='y'";
        db.query(GKs,[GK], function (err, result) {
          
       if (err)
       {
         res.json("The player cannot be added")

        }
  
      else
     {
        ////////
        var GKss = "UPDATE players SET available = 'n' WHERE lName like ?";
        db.query(GKss,[GK], function (err, result) {

          if (err)
          res.json("Error")

           else 
           {

          //
          var GKsss = 'UPDATE teamposition SET GK = ? WHERE email =?';
          db.query(GKsss,[req.query.GK,ema], function (err, result) {
  
            if (err)
            res.json("Error")
  
             else 
           res.json("done")
  
           
          });
          //
        }
         
        });
        /////
    
     }
      });


/////////////////////////////////////////////////////////

    
       // res.send(result);
    
      } 
      else 
      {
        res.json("not found email ");
      }
    
    });
    });




module.exports=appl;