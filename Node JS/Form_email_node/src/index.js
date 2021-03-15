const express = require("express")
const app = express()
const path = require("path")
//https://www.youtube.com/watch?v=wu-1LpCyu1Y&t=38s
app.use(express.urlencoded({extended:false}))
//Para aplicaciones con React o Vue
//app.use(express.json())

app.use(require("./routes/index"))

app.use(express.static(path.join(__dirname, "public")))

app.listen(3000, ()=>{
    console.log("server on port 3000")
})