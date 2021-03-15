let palabra="como seria";
console.log(palabra.length);
let palabramayus = palabra.toUpperCase();
console.log(palabra.toUpperCase());
console.log(palabramayus);
console.log(palabramayus.toLowerCase());
console.log(palabra.indexOf("s"));
console.log(palabra.replace("seria","es"));
console.log(palabra.substring(3));
console.log(palabra.substring(3, 7));
console.log(palabra.slice(-3));

let palabra2="        Como es, como seria";
console.log(palabra2.trim());

console.log(palabra.startsWith("c"));
console.log(palabra.startsWith("s",5));
console.log(palabra.endsWith("a"));
console.log(palabra.includes("i"));

let palabra3="Hola";

console.log(palabra3.repeat(3));

let nombre="Miguel";
let apellido="Valbuena";
let edad= 19;

console.log(nombre+" "+apellido+" Tienes "+edad+" años");
console.log(`Hola ${nombre} ${apellido} tienes ${edad} años`);