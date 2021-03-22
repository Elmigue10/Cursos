let listaUsuarios = document.getElementById("lista-usuarios")
let boton = document.getElementById("boton")

function reqListener () {
    const usuarios = JSON.parse(this.responseText)
    console.log("Usuarios ", usuarios)
    const usuariosRender = usuarios.map((usuario)=> {
        return `<li>${usuario.nombre}</li>`
    }).join("--------")
    console.log("Usuarios render ",usuariosRender)
    listaUsuarios.innerHTML = usuariosRender
}

let peticion = new XMLHttpRequest();
peticion.addEventListener("load", reqListener);
peticion.open("GET", "https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios");
peticion.send();

function enviar(){
    peticion.open("POST", "https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios", true)
    peticion.setRequestHeader(
        "Content-type",
        "application/x-www-form-urlencoded"
        )
        peticion.send("nombre=nuevoUsuario2")
        setTimeout(refresh,3000)
    }
    
    
function refresh(){
    peticion.open("GET", "https://bootcamp-dia-3.camilomontoyau.now.sh/usuarios");
    peticion.send();
}

boton.onclick = enviar

boton.addEventListener("click",enviar)