const fabricaPromesas  = (indice) => 
    new Promise((resolve, reject)=>{
    const rejectTime = Math.floor(Math.random()*10000) + 1000
    const resolveTime = Math.floor(Math.random()*10000) + 1000


    setTimeout(()=>{resolve(`La promesa con indice ${indice} se resolvio.`)},resolveTime)
    setTimeout(()=>{reject(`La promesa con indice ${indice} fallo.`)},rejectTime)
})

// let misPromesas = []

// for (let i = 0 ; i<10; i++){

//     misPromesas = [...misPromesas,fabricaPromesas(i)]
// }

// Promise.allSettled(misPromesas).then((respuesta)=>console.log(respuesta)).catch((razon)=>console.log(razon))

async function miAsyncFuncion(){
    try {
        const miPromesa1 = await fabricaPromesas(1)
        console.log(`Valor de mi promesa 1: ${miPromesa1}`)
        return miPromesa1
    } catch (error) {
        console.log(error)
    }
}

function miFuncion(){
    const miPromesa2 = fabricaPromesas(2)
        .then(resultado=>console.log(resultado))
        .catch(razon => console.log(razon))
}