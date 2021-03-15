const person = {
    name: "miguel",
    age : 19,
    email : "elcomoseria@gmail.com"
}

// const {name:nombre,age:edad,email} = person 
// const {name,age,email} = person 

// console.log(nombre,edad,email)
// console.log(name,age,email)

const numbers = [1,2,3,4,5]

const [primeraPosicion] = numbers
const [a,b,terceraPosicion] = numbers

console.log(primeraPosicion);
console.log(terceraPosicion);


// const printPerson = ({ name }) => {
//     console.log(name)
// }

// // const printPerson = ({ name: nombre }) => {
// //     console.log(nombre)
// // }

// printPerson(person)


const getUsers = async () => {
    const { data: users } = await axios.get('https://jsonplaceholder.typicode.com/users')

    console.log(users)
}

getUsers()