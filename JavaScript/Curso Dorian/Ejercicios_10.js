/*Primer ejercicio*/
let nombre= prompt("Escribe tu nombre");
let edad= parseInt(prompt("Dijite su edad"));

console.log(`Primer ejercico.
Hola ${nombre} tienes ${edad} y el año que viene tendras ${edad+1}`);
/*Segundo ejercicio*/
console.log(`Escoge una opcion:`);
console.log(`1-Triangulo`);
console.log(`2-Rectangulo`);
console.log(`3-Circulo`);
console.log(`0-Salir`);
let j=10;
while(j>0){
    let opcion=parseInt(prompt("Dijita la opcion."));
    if(opcion==1){
        let base= parseInt(prompt("Dijita la base del triangulo"));
        let altura= parseInt(prompt("Dijita la altura del triangulo"));
        let area= (base*altura)/2;
        console.log(`El area del triangulo es igual a: ${area}`);
    }
    if(opcion==2){
        let base= parseInt(prompt("Dijita la base del rectangulo"));
        let altura= parseInt(prompt("Dijita la altura del rectangulo"));
        let area= base*altura;
        console.log(`El area del rectangulo es de : ${area}`);
    }
    if(opcion==3){
        let pi=(Math.PI);
        let radio=parseInt(prompt("Dijita el radio de la circunferencia."));
        let area=pi*(Math.pow(radio,2));
        console.log(`El area de la circunferencia es de: ${area}`);
    }
    if(opcion==0){
        break
    }
}
/*Tercer ejercicio*/
let numero = parseInt(prompt("Ingrese un numero"));
for (let i=1;i<=numero;i++){
    if(i%2==0){
        console.log(`${i} es par`);
    }
    if(i%2!=0){
        console.log(`${i} es impar`);
    }
}
/*Cuarto ejercicio*/
let num= parseInt(prompt("Dijita un numero"));
let divisores = 0;
for(let i=2; i<num;i++){
    if(num%i==0){
        console.log(`${num}/${i}=${num/i} No es primo`);
        divisores ++;
        break;
    }
}
if (divisores==0){
    console.log(`${num} es primo`)
}
/*Quinto ejercicio*/
let num = parseInt(prompt("Dijite un numero"));
let result= 1;
for(let i=num;i>0;i--){
    console.log(i);
    console.log("*");
    result *=i;
}
console.log(`El factorial de ${num} es igual a ${result}`);
/*Sexto ejercicio*/
let contador=0;
let suma=0;
while (suma<=50){
        suma += parseInt(prompt("Ingrese un numero"));
        contador ++;
    }
console.log(suma);
console.log(contador);
/*Septimo ejercicio*/
let numeros=[1,2,3,4,5];
let pares=[];
let impares=[];
for (const number of numeros){
    let random=Math.random()*10+1;
    const  result= Math.round(number * random);
    if(result%2==0){
        pares.push(result);
    }
    else{
        impares.push(result);
    }
}
console.log(pares);
console.log(impares);
/*Octavo ejercicio*/
const letras=["T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E","T"];
const dni= prompt("Introducir dni");
if(dni.length==8 && parseInt(dni)>0){
    let letra= dni%23;
    console.log("Tu dni completo es ${dni} ${letras[letra]}");
}
/*Noveno ejercico*/
const palabra= prompt("Introduce una palabra").toLowerCase();
let consonantes=0;
let vocales=0;
for (const letra of palabra){
    if (letra =="a" ||letra=="e"||letra=="i"||letra=="o"||letra=="u"){
        vocales ++;
    }
    else{
        consonantes ++;
    }
}
console.log(`Tu palabra tiene ${consonantes} consonantes y ${vocales} vocales y un total de ${palabra.length} letras`);
/*Decimo ejercicio*/
const colors=["azul","amarillo","rojo","verde","rosa"];

let entrada=prompt("Introduzca un color").toLowerCase();
if (colors.indexOf(entrada)!==-1){
    console.log(`El color ${entrada} ya se encuentra en el arreglo en la posicion ${colors.indexOf(entrada)+1}.`);
}
else{
    console.log(`El color ${entrada} no se encuentra en el arreglo.`)
}



