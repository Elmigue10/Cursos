setTimeout(()=>{
    console.log("Soy un callback")
},3000)

const callBack = () => {
    console.log("Soy un callback")
}

setTimeout(callBack,3000)

const callBack2 = () => {
    setTimeout(()=>{
        console.log("Soy un callback")
    },3000)
}


function sumar(num1,num2){
    return num1+num2
}
function restar(num1,num2){
    return num1-num2
}
function multiplicar(num1,num2){
    return num1*num2
}
function multiFuncion(num1,num2, operacion){
    const resultado = operacion(num1,num2)
    console.log(resultado)
}

multiFuncion(3,5,sumar)


const miBoton = document.getElementById("miBoton")

const clickFunction = (e) => {
    console.log(e)
    alert("Diste click en el botón")
}

miBoton.addEventListener("click",clickFunction)


// Callback hell
// setTimeout(()=>{
//     console.log("Ejecución 1"),
//     setTimeout(()=>{
//         console.log("Ejcución 2")
//         setTimeout(()=>{
//             console.log("Ejecución 3")
//             setTimeout(()=>{
//                 console.log("Ejecución 4")
//             },3000)
//         },3000)
//     },3000)
// },3000)

const funcion4 = () => {
    console.log("Ejecución 4")
}

const funcion3 = () => {
    console.log("Ejecución 3")
    setTimeout(funcion4,3000)
}

const funcion2 = ()=>{
    console.log("Ejecución 2")
    setTimeout(funcion3,3000)
}

const funcion1 = ()=>{
    console.log("Ejecución 1"),
    setTimeout(funcion2,3000)
}

setTimeout(funcion1, 3000);

