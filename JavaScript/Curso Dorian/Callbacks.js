console.log("Un callback es una funcion que se ejecuta a traves de una funcion.");
function getUser (id, cb) {
    let user = {
        name:"Miguel",
        id: id
    }
    if(id==2){
        cb("El usuario no exist", user);
    }
    else{
        cb(null, user);
    }
}
getUser(1,function(error,user){
    if(error){
        return console.log(error);
    }
    else{
        console.log(user.name);
    }
});
//Segundo ejemplo.
let users = [
    {
        id:1,
        name:"Miguel"
    },{
        id:2,
        name:"Juan"
    },{
        id:3,
        name:"Luis"
    }
]

let emails = [
    {
        id:1,
        email:"miguel@gmail.com"
    },{
        id:2,
        email:"juan@gmail.com"
    }
]

function getUsers(id,cb){
    let user = users.find(user=>user.id==id);
    if(!user)/*Significa que no existe*/{
        cb(`No existe un usuario con el id ${id}`)
    }
    else{
        cb(null, user)
    }
}

function getEmail (user,cb) {
    let email =  emails.find(email=>email.id == user.id);
    if(!email){
        cb(`${user.name} no tiene email.`);
    }
    else{
        cb(null, user);
    }
}

getUsers(3,(error,user)=>{
    if(error)/*Significa que no existe*/{
        return console.log (error)
    }
    getEmail(user, (error,res)=>{
        if(error){
            return console.log(error);
        }
        console.log(res);
    })
});