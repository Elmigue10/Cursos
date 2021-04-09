let productosContainer = document.getElementById("productos")

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
            <img src="${producto.imagen}"></img>
        </div>
        <div class="contentContainer">
            <li class="nombreProducto">${producto.nombre}</li>
            <li class"descripcionProducto">${producto.descripcion}</li>
            <li class="precioProducto">$${producto.precio}</li>
            <button class="btn btn-outline-success" id="buttonCarrito">Agregar <span class="icon-cart"></span></button>
        <div>
        </div></ul>`
    }).join("")
    productosContainer.innerHTML = productosRender
}


