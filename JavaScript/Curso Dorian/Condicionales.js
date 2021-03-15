let numero = 5;
let num = -2;

if(numero>0){
    console.log(`${numero} es mayor que cero`);
}
else if(numero<0){
    console.log(`${numero} es menor que cero`)
}
else{
    console.log(`${numero} es menor que cero`);
}

if(numero>0 && num>0 ){
    console.log(`${numero} y ${num} son mayores que cero`);   
}
if(numero>0 || num>0 ){
    console.log(`${numero} y ${num} alguno de los dos es mayor que cero`);   
}

let word="hola";
if(word.length>=4){
    console.log(`La palabra ${word} tiene 4 o mas letras`)
}