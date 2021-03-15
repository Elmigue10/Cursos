let numeros = [112,12,32,43,32,43,-13];

function sumarnumeros (a,b,c){
    return a+b+c;
}

let numerossumar = [1,2,3];

sumarnumeros(...numerossumar);

let usuarios=["Oscar", "Javier","Miguel","Angel"];

let usuariosnuevos=["Juan","David"];

usuarios.push(...usuariosnuevos);

console.log(usuarios);

let arr1=[1,2,3,4];
let arr2=[...arr1];

console.log(arr2);

let arr3=[1,2,3,4,5];
let arr4=[6,7,8];

let arrConcat= arr3.concat(arr4);
console.log(arrConcat);

function restParams (...numeros){
    console.log(numeros);
}
restParams();

console.log(Math.max(...numeros));
console.log(Math.min(...numeros));

console.log([...new Set(numeros)]);