let numeros= [1,2,3,4,5];
console.log(numeros);
console.log(numeros[3]);
let palabras=["como", "es", "como", "seria"];
console.log(palabras);
console.log(palabras[3]);

console.log(numeros.length);
Array.isArray(numeros);

console.log(numeros);
numeros.shift();
console.log(numeros);
numeros.pop();
console.log(numeros);
numeros.push(5);
console.log(numeros);
numeros.unshift(1);
console.log(numeros);
console.log(numeros.indexOf(4));
console.log(numeros.join("-"));
/*numeros.splice(3);
numeros.splice(2,2);
numeros.splice(2,2, 12, 26, 53);
a es el indice, b es el numero de elementos despues del indice
numeros.splice(2,0, 12, 26, 53);
Si b vale 0, no elimina, solo reemplaza*/
numeros.slice(2,3);
console.log(numeros.slice(1,3));
