let listaUsuarios = document.getElementById("lista-usuarios")
let boton = document.getElementById("boton")
let inputName = document.getElementById("inputName")

let usuarios = []

function render () {

    const usuariosRender = usuarios.map((usuario)=> {
        return `<tr><td>${usuario.nombre}</td></tr>`
    }).join("")
    console.log("Usuarios render ",usuariosRender)
    listaUsuarios.innerHTML = usuariosRender
}

function enviar(){
    const datos = {nombre: inputName.value}
    fetch("https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios",{
        method:"POST",
        headers:{
            "Content-Type":"application/json"
    },
    body: JSON.stringify(datos)
    })
    .then((response) => response.json())
    // .then((data)=> {
    //     console.log("Succes ", datos)
    // })
    .then(respuestaJson => {
        console.log("respuesta json ", respuestaJson)
        refresh()
    })
    .catch((error)=>{
        console.log("Error ", error)
    })
}
    
    
function refresh(){
    fetch("https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios")
    .then((response)=> response.json())
    .then((respuestaUsuarios)=>{
        console.log("respuesta usuarios ",respuestaUsuarios)
        usuarios = respuestaUsuarios
        render()
    })
    // Ó
    // fetch("https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios",
    //     {method:"GET"}
    // )
}

refresh()

// boton.onclick = enviar

boton.addEventListener("click",enviar)