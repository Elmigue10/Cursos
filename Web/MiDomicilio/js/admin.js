let productosContainer = document.getElementById("productos")
let id = document.getElementById("id") 
let nombre = document.getElementById("nombre") 
let precio = document.getElementById("precio") 
let descripcion = document.getElementById("descripcion") 
let cantidad = document.getElementById("cantidad") 
let categoria = document.getElementById("categoria") 
let unidad = document.getElementById("unidad") 
let enviarBoton = document.getElementById("enviarBoton")


let productos = []


const getUsers = () => {
    // axios.get('https://reqres.in/api/users')
    axios.get('http://localhost:8080/getProductos')
    .then(response => {
        const respuestaProductos = response.data;
        console.log(`GET respuestaProductos`, respuestaProductos);
        productos = respuestaProductos
        render();
    })
     .catch(error => console.error(error));
    };
getUsers();

function render () {
    const productosRender = productos.map((producto)=>{
        return `<ul><div class="productosContainer">
        <div class="imagenContainer">    
            <img src=".${producto.imagen}"></img>
        </div>
        <div class="contentContainer">
            <li class="nombreProducto">${producto.nombre}</li>
            <li class"descripcionProducto">${producto.descripcion}</li>
            <li class="precioProducto">$${producto.precio}</li>
        <div>
        <div class="buttonsContainer">
            <a class="btn btn-outline-success" href="#formEditar" id="buttonEditar">Editar<span class="icon-pencil"></span></a>
            <button class="btn btn-outline-success" id="buttonEliminar">Eliminar<span class="icon-bin"></span></button>
        </div>
        </div></ul>`
    }).join("")
    productosContainer.innerHTML = productosRender
}

function enviarProducto(e) {
    e.preventDefault();
    
    const data = {
        id:id.value,
        nombre:nombre.value,
        precio:precio.value,
        cantidad:cantidad.value,
        descripcion:descripcion.value
    }
    console.log(data)
}


enviarBoton.onclick = enviarProducto