// Manera de trabajar con objectos o array de una forma mas simple
let miObjeto = {
    a:1,
    b:2,
    c:"Hola",
    d: function(){
        console.log("Soy una función")
    },
    e: true
}

let {a,b} = miObjeto

let {a,b,c,d,e} = miObjeto

//Spread operator

let {d, ...otros} = miObjeto

//Ejemplo con array
let miArray = [1,2,"Hola", ()=> console.log("Soy una función"), true]

let [numeroUno, numeroDos, hola, unaFuncion, buleano] = miArray

//Spread operator

let [numeroUno, ...resto] = miArray
