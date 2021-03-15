// const element = document.createElement("h1");

// element.innerText = "Hola React";

// const contenedor = document.getElementById("root");

// contenedor.appendChild(element);

import React from "react";
import ReactDOM from "react-dom"

//DOM
const name = "Miguel";
const etiqueta = <h1>Hola {name}</h1>  

//JSX
const user = {
    name:"Miguel",
    lastName:"Valbuena",
    avatar:"https://cdn4.iconfinder.com/data/icons/avatars-xmas/giveaway/128/batman_hero_a"
}
//Funciones con JSX
function getName(user){
    return `${user.name} ${user.lastName}`
}

function getGreeting (user){
    if(user){
        return `${user.name} ${user.lastName}`
    }
    return <h1>Hello Stranger</h1>
}
//Invocacion JSX
const elemento = <h1>Hola {getName(user)}</h1>
const funcion = <div>{getGreeting(user)}</div>
const imagen = <div>
        <h1>avatar</h1>
        <img src={user.avatar} alt={"Batman"}/>
    </div>
const content = document.getElementById("saludo");
const img = document.getElementById("image");

//Invocacion DOM
const element = <h1>Hola React</h1>
const contenedor = document.getElementById("root");

// ReactDOM.render(QUE, DONDE);

ReactDOM.render(element, contenedor);

//ReactJSX
//ReactDOM.render(etiqueta, content);
//ReactDOM.render(elemento, content);
ReactDOM.render(funcion, content);
ReactDOM.render(imagen, img);