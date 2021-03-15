let word= "Como seria";
console.log(Array.from(word));
console.log(word.split(""));

let letras =["z","a","y","b","x","c"];
console.log(letras.sort());

let numeros =[21,23,34,342,2];

console.log(numeros.sort((a,b) => a-b));
console.log(numeros.sort((a,b) => b-a));

numeros.forEach((Number)=>console.log(Number));
numeros.forEach((Number, index)=> console.log(`${Number} esta en la posicon ${index}`));

const palabras = ["como", "es", "como", "seria"];

console.log(palabras.some(word => word.length>2));
console.log(palabras.every(word => word.length>2));

let numeros2 = numeros.map(Number=> Number*2);
console.log(numeros2);

let numeros3 = numeros.filter(Number => Number>20);
console.log(numeros3);

console.log(numeros.reduce((a,b)=>a+b));

let usuarios = [
    {
        name:"user 1",
        online:"true"
    },
    {
        name:"user 2",
        online:"false"
    },
    {
        name:"user 3",
        online:"true"
    },
    {   
        name:"user 4",
        online:"false"
    }
]

const usersOnline = usuarios.reduce((cont, user)=>  {
    if (user.online) cont ++;
    return cont;
},0) 
console.log(`${usersOnline} usurarios conectados`);