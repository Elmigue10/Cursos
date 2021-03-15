const numbers=document.getElementById("numbers");
const result=document.getElementById("result");

let a= prompt("Dijite el primer numero");
let b= prompt("Dijite el segundo numero");
let c= prompt("Dijite el tercer numero");

numbers.textContent= `Los numeros dijitados son ${a} ${b} ${c}`

if(a>=b && a>=c){
    if(b>c){
        result.textContent= `${a} ${b} ${c}`
    }
    if(c>b){
        result.textContent= `${a} ${c} ${b}`
    }
}
if(b>=a && b>=c){
    if(a>c){
        result.textContent= `${b} ${a} ${c}`
    }
    if(c>a){
        result.textContent= `${b} ${c} ${a}`
    }
}
if(c>=b && c>=a){
    if(b>a){
        result.textContent= `${c} ${b} ${a}`
    }
    if(a>b){
        result.textContent= `${c} ${a} ${b}`
    }
}