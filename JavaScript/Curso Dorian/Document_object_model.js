const title = document.getElementById("title");
title.textContent="DOM-Acceder a nodos";

const paragraph = document.querySelector(".paragraph:nth-child(2)");
const span = document.querySelectorAll(".span");
span[0].style.color="red";

const name = document.getElementById("name");

console.log(title);
console.log(name);

console.log(name.getAttribute('type'));
name.setAttribute('type','date');
title.classList.add("main-title","other-title")

console.log(name);
console.log(title);
console.log(title.innerHTML);


const button= document.getElementById("button");
const box=document.getElementById("box");
const input=document.getElementById("input");

button.addEventListener("click",()=>{
    console.log("CLICK");    
}
);
button.addEventListener("dblclick",()=>{
    console.log("DOBLE CLICK")
});
box.addEventListener("mouseenter",() => {
    box.style.background="green";
});
box.addEventListener("mouseleave",()=>{
    box.style.background="red";
});
box.addEventListener("mousedown", ()=>{
    console.log("Has pulsado en el parrafo.")
})
box.addEventListener("mousemove",()=>{
    console.log("El raton se esta moviendo")
})
input.addEventListener("keyup",()=>{
    console.log("Se solto una tecla");
});
input.addEventListener("keydown",()=>{
    console.log("Se bajo una tecla");
});
input.addEventListener("keypress",()=>{
    console.log("Se presiono una tecla")
})

const form = document.getElementById("form");
const objeto = document.getElementById("objeto");
const objeto_button= document.getElementById("objeto_button");
const gallery= document.getElementById("gallery");

objeto.addEventListener("keyup", (evento) => {
    console.log(evento);
});
addEventListener("click",(evento) =>{
    console.log(evento);
});
objeto_button.addEventListener("click",(evento)=>{
    console.log(evento.target);
});

gallery.addEventListener("click", (evento)=>{
    console.log(evento.target.textContent);
})

form.addEventListener("submit",(evento)=>{
    evento.preventDefault();
    console.log("El formulario se ha enviado");
});

form.submit();


const days=["Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"];
const daysList= document.getElementById("daysList");
const selectDays = document.getElementById("daysSelect");

const itemList= document.getElementById("LI");
//itemList.textContent="Lunes";
//daysList.appendChild(itemList);
title.innerHTML="DOM- <span>Crear e insertar elementos</span>";
/*for(const day of days){
    const itemList = document.getElementById("LI");
    itemList.textContent=day;
    fragment.appendChild(itemList);
}*/
for(const day of days){
    const selectItem=document.getElementById("OPTION")
    //selectItem.setAttribute("value", day.toLowerCase())
    //selectItem.textContent=day
    //fragment.appendChild(selectItem)
}

//selectDays.appendChild(fragment);


const parent=document.getElementById("parent");
/*console.log(parent.childNodes);
console.log(parent.children[2]);
console.log(parent.firstChild);
console.log(parent.firstElementChild);
console.log(parent.lastChild);
console.log(parent.lastElementChild);
console.log(parent.hasChildNodes());*/
console.log(parent.nextSibiling);
console.log(parent.nextElementSibiling);


const list1= document.getElementById('list1')
const newElement = document.getElementById('li')
//newElement.textContent="Soy un elemento nuevo"

/*list1.insertBefore(newElement, list1.children[1]);
list1.children[1].insertAdjacentElement("afterend",newElement)*/

list1.prepend(newElement);
list1.after(list1.cloneNode(true));

list1.remove();
list1.removeChild(list1.children[0]);


const button1=document.getElementById("button1");

window.alert("hola");
if(confirm("Acepta?")){
    console.log("Ha aceptado");
}
else{
    console.log("No ha aceptado");
}

let person = {
    name:"Miguel",
    lastname:"Valbuena",
    age:19
}
console.table(person);
console.log(location.href);
console.log(location.protocol);
console.log(location.host);
console.log(location.pathname);
console.log(location.hash);

const date= new Date();
console.log(date);
console.log(date.getDay());
button1.addEventListener("click",()=>{
    setTimeout(()=>{
        console.log("Hola");
    },5000)
});
const saludar = ()=>{
    console.log("Hola");
}
const interval = setInterval(saludar,3000);