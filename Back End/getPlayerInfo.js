const DB =require('./databaseConect')
DB.databas();

  // this is used to get the information needed for the player 
  //(name , age ,position , price ... etc)

  con.connect(function(err) {
    if (err) throw err;
    con.query("SELECT * FROM Palyer WHERE short_name = 'L.Messi'", function (err, result) {
      if (err) throw err;
      console.log(result);
      
    });
  });