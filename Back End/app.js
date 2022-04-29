
const express =require('express');
const bodyParser=require('body-parser');
const session = require('./session');
//const app = express.Router();








const app=express();
app.use(bodyParser.json());
app.use(session);



const Login=require('./login');
const SignUp=require('./SignUp');
const Logout = require('./logout');




const searchPlayers=require('./searchPlayers');

app.use('/login',Login)
app.use('/SignUp',SignUp)
app.use('/logout',Logout)
app.use('/searchPlayers',searchPlayers)



// create the homepage route at '/'
app.get('/', (req, res) => {
  console.log('Inside the homepage callback function')
  console.log(req.sessionID)
  res.send(`You hit home page!\n`)
})



app.listen('3000',()=> 
{
  console.log('server started on port 3000');

});

