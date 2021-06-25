import mongoose from "mongoose"
import config from "./config"

(async ()=>{
    try {
        const db = await mongoose.connect(config.mongodbUrl,{
            useNewUrlParser: true,
            useUnifiedTopology: true,
            useFindAndModify: false
        })
        console.log("Database is connect to: ",db.connection.name)
    } catch (error) {
        console.error(error)
    }
})()