const getName = async () => {
    return new Promise((resolv,reject)=>{
        setTimeout(()=>{
        resolv("Miguel")
        },1500)
    })
}

const sayHello = async () =>{
    const name = getName();
    retunr `Hello ${name}`
}

console.log(sayHello());

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

const getUsers = async (id) => {
    let user = users.find(user=>user.id==id);
        if(!user)/*Significa que no existe*/{
            throw new Error (`No existe un usuario con id ${id}`);
        }
        else{
            return user;
        }
}

const getEmail = async(user) => {
    let email =  emails.find(email=>email.id == user.id);
        if(!email) {
            throw new Error (`${user.name} no tiene email.`)
        }
        else{
            return ({
                id: user.id,
                name: user.name,
                email: user.email
            })
        }
}

const getInfo = async(id)=>{
    try {
    const user = await getUser(id);
    const res = await getEmail(user);
    return `${user.name} el email es ${res.email}`
    }
    catch (error){
        console.log(error)
    }
} 
getInfo().then(res=>console.log(res));
