const fabricaPromesas  = (indice) => 
    new Promise((resolve, reject)=>{
    const rejectTime = Math.floor(Math.random()*10000) + 1000
    const resolveTime = Math.floor(Math.random()*10000) + 1000
    // resolve("La promesa fue resuelta")
    // reject("La promesa falló")
    setTimeout(()=>{resolve(`La promesa con indice ${indice} se resolvio.`)},resolveTime)
    setTimeout(()=>{reject(`La promesa con indice ${indice} fallo.`)},rejectTime)
})

let misPromesas = []

for (let i = 0 ; i<10; i++){

    misPromesas = [...misPromesas,fabricaPromesas(i)]
}

// miPromesa.then((respuesta)=>{
//     console.log(respuesta)
// },(razon) => {console.log(razon)})

// misPromesas.forEach((promesaActual)=>
//     promesaActual
//     .then((respuesta)=>console.log(respuesta))
//     .catch((razon)=>console.log(razon)
// ))

// Promise.all(misPromesas).then((respuesta)=>console.log(respuesta)).catch((razon)=>console.log(razon))

Promise.allSettled(misPromesas).then((respuesta)=>console.log(respuesta)).catch((razon)=>console.log(razon))