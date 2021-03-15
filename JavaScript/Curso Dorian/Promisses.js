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
];

let emails = [
    {
        id:1,
        email:"miguel@gmail.com"
    },{
        id:2,
        email:"juan@gmail.com"
    }
];  

function getUsers(id){
    let user = users.find(user=>user.id==id);
    let promise = new Promise ((resolve, reject)=>{
        if(!user)/*Significa que no existe*/{
            reject(`No existe un usuario con id ${id}`);
        }
        else{
            resolve(user);
        }
    })
    return promise
}

function getEmail (user) {
    let email =  emails.find(email=>email.id == user.id);
    let promise = new Promise ((resolve,reject)=>{
        if(!email) {
            reject (`${user.name} no tiene email.`)
        }
        else{
            resolve ({
                id: user.id,
                name: user.name,
                email: user.email
            })
        }
    })
    return promise;
}

getUsers(3)
    .then(user=>{
        return getEmail(user);
    })
    .then(res=>console.log(res))
    .catch(error => console.log(error))

// if(error)/*Significa que no existe*/{
//     return console.log (error)
// }
// getEmail(user, (error,res)=>{
//     if(error){
//         return console.log(error);
//     }
//     console.log(res);
// })