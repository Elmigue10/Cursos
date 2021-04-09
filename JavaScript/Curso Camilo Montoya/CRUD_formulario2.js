let listaUsuarios = document.getElementById("lista-usuarios")
let usuario = []

function obtenerIndice() {
    return indiceUsuario = location.search.replace("?","").split("=")[1]
}

function obtenerUsuario(){
    fetch(`https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios/${obtenerIndice()}`)
    .then((response)=> response.json())
    .then((respuestaUsuario)=>{
        console.log("respuesta usuario ",respuestaUsuario)
        usuario = respuestaUsuario
        render()
    })
}

obtenerUsuario()

function render () {

    const usuarioRender = `<tr>
            <td>${usuario.nombre ? usuario.nombre : "vacio"}</td>
            <td>${usuario.apellido ? usuario.apellido : "vacio"}</td>
            <td>${usuario.pais ? usuario.pais : "vacio"}</td>
       </tr>`
    // console.log("Usuarios render ",usuariosRender)
    listaUsuarios.innerHTML = usuarioRender
}