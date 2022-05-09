
const express =require('express');
const bodyParser=require('body-parser');
const session = require('./BusinessLayer/session');
const authenticate = require('./BusinessLayer/authenticate');
//const app = express.Router();








const app=express();
app.use(bodyParser.json());
app.use(session);



const Login=require('./Presentation+PresistenceLayer/login');
const SignUp=require('./Presentation+PresistenceLayer/SignUp');
const Logout = require('./Presentation+PresistenceLayer/logout');
const searchPlayers=require('./Presentation+PresistenceLayer/searchPlayers');
const teamposition=require('./Presentation+PresistenceLayer/teamposition');
const GK=require('./Presentation+PresistenceLayer/Team/GK');


app.use('/login',Login)
app.use('/SignUp',SignUp);
app.use('/logout',Logout)
app.use('/searchPlayers',searchPlayers)
app.use('/teamposition',teamposition)
app.use('/GK',GK)

app.use(authenticate);


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

