const express = require("express")
const app = express()
const path = require("path")
const mysql = require('mysql')
const session = require('express-session');
const bodyParser = require('body-parser');
//https://www.youtube.com/watch?v=wu-1LpCyu1Y&t=38s
app.use(express.urlencoded({extended:false}))
//Para aplicaciones con React o Vue
//app.use(express.json())

app.use(require("./routes/index"))

app.use(express.static(path.join(__dirname, "public")))

/*app.listen(3000, ()=>{
    console.log("server on port 3000")
})*/

//Conexion
const connection = mysql.createConnection({
	host     : 'localhost',
	user     : 'root',
	password : '',
	database : 'nodelogin'
});

app.use(session({
	secret: 'secret',
	resave: true,
	saveUninitialized: true
}));

app.use(bodyParser.urlencoded({extended : true}));
app.use(bodyParser.json());

app.get('/', function(request, response) {
	response.sendFile(path.join(__dirname + '/public/login.html'));
});

app.post('/auth', function(request, response) {
	var username = request.body.username;
	var password = request.body.password;
	if (username && password) {
		connection.query('SELECT * FROM accounts WHERE username = ? AND password = ?', [username, password], function(error, results, fields) {
			if (results.length > 0) {
				request.session.loggedin = true;
				request.session.username = username;
				response.redirect('/home');
			} else {
				response.send('Incorrect Username and/or Password!');
			}			
			response.end();
		});
	} else {
		response.send('Please enter Username and Password!');
		response.end();
	}
});

app.get('/home', function(request, response) {
	if (request.session.loggedin) {
		response.send('Welcome back, ' + request.session.username + '!');
	} else {
		response.send('Please login to view this page!');
	}
	response.end();
});

//app.listen(3000);
app.listen(3000, ()=>{
    console.log("server on port 3000")
})