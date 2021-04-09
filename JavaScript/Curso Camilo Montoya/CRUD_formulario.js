let listaUsuarios = document.getElementById("lista-usuarios")
let boton = document.getElementById("boton")
let limpiar = document.getElementById("limpiar")
let indice = document.getElementById("indice")
let inputName = document.getElementById("name")
let lastName = document.getElementById("lastName")
let country = document.getElementById("country")

let usuarios = []
let botonesEliminar = null
let botonesEditar = null

function render () {

    const usuariosRender = usuarios.map((usuario, indice)=> {
        return `<tr>
            <td>${usuario.nombre ? usuario.nombre : "vacio"}</td>
            <td>${usuario.apellido ? usuario.apellido : "vacio"}</td>
            <td>${usuario.pais ? usuario.pais : "vacio"}</td>
            <td><a class="ver" href="/CRUD_formulario2.html?usuario=${indice}">Ver</a></td>
            <td><button class="editarButton" data-indice=${indice}>Editar</button></td>
            <td><button class="eliminarButton" data-indice=${indice}>Eliminar</button></td>
       </tr>`
    }).join("")
    // console.log("Usuarios render ",usuariosRender)
    listaUsuarios.innerHTML = usuariosRender
    botonesEliminar = document.getElementsByClassName("eliminarButton")
    Array.from(botonesEliminar).forEach(botonEliminar => {
        botonEliminar.onclick = eliminar
        })
    botonesEditar = document.getElementsByClassName("editarButton")
    Array.from(botonesEditar).forEach(botonEditar => {
        botonEditar.onclick = editar
        })
}

function enviar(e){
    e.preventDefault()

    let accion = e.target.innerText

    const datos = {
        nombre: inputName.value, 
        apellido : lastName.value, 
        pais : country.value
    }
    let url = null 
    let method = null
    if(accion === "Enviar"){
        url = "https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios"
        method = "POST"
    }
    else if(accion === "Editar"){
        if(indice.value){
            url = `https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios/${indice.value}`
            method = "PUT"
        }
        else{
            return
        }
    }
    else{
        return
    }

    fetch(url,{
        method:method,
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
        restaurarBoton()
    })
    .catch((error)=>{
        console.log("Error ", error)
        restaurarBoton()
    })
}

function editar(e){
    e.preventDefault();
    if(e.target.dataset.indice){
        const usuario = usuarios[e.target.dataset.indice]
        inputName.value = usuario.nombre ? usuario.nombre : ""
        lastName.value = usuario.apellido ? usuario.apellido : ""
        country.value = usuario.pais ? usuario.pais : ""
        indice.value = e.target.dataset.indice
        boton.innerText = "Editar"
    }
    else{
        boton.innerText = "Enviar"
    }

    const datos = {
        nombre: inputName.value, 
        apellido : lastName.value, 
        pais : country.value
    }

    fetch(`https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios/${e.target.dataset.indice}`,{
        method:"PUT",
        headers:{
            "Content-Type":"application/json"
        },
        body: JSON.stringify(datos)
    })
    .then((response) => response.json())
    .then(respuestaJson => {
        console.log("respuesta json ", respuestaJson)
        refresh()
    })
    .catch((error)=>{
        console.log("Error ", error)
    })
}

function eliminar(e){
    e.preventDefault();
    fetch(`https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios/${e.target.dataset.indice}`,{
        method:"DELETE"
    })
    .then((response) => response.json())
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

function restaurarBoton(params) {
    boton.innerText = "Enviar"
    inputName.value = ""
    lastName.value = ""
    country.value = ""
}

refresh()

boton.onclick = enviar
// boton.addEventListener("click",enviar)

limpiar.addEventListener("click", ()=>boton.innerText = "Enviar")