
const express =require('express');
const bodyParser=require('body-parser');
//const app = express.Router();

const app=express();
app.use(bodyParser.json());


const Login=require('./login');
const SignUp=require('./SignUp');

//const GetPlayer=require('./getPlayerInfo');

app.use('/login',Login)
app.use('/SignUp',SignUp)

//app.use('/getplayer',GetPlayer)


app.listen('3000',()=> 
{
  console.log('server started on port 3000');

});

