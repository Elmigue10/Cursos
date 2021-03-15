const button = document.getElementById('button')
//res = response = respuesta
button.addEventListener('click', () => {
    fetch('https://jsonplaceholder.typicode.com/users')
        .then(res => res.ok ? Promise.resolve(res) : Promise.reject(res))
        .then(res => res.json())
        .then(res => {
            const list = document.getElementById('list')
            const fragment = document.createDocumentFragment()
            for (const userInfo of res) {
                const listItem = document.createElement('LI')
                listItem.textContent = `${userInfo.id} - ${userInfo.name}`
                fragment.appendChild(listItem)
            }
            list.appendChild(fragment)
        })
});

const send = document.getElementById("send");
send.addEventListener("click",()=>{
    const newPost = {
        title:"New post",
        body:"Lorem asda gfs gers csade",
        userId:1
    }
    fetch ('https://jsonplaceholder.typicode.com/users',{
        method:"POST",
        body:JSON.stringify(newPost),
        headers:{
            "Content-type": "application/jason"
        }
    }).then(res=>res.json()).then(data=>console.log(data))
});

const leerImg = document.getElementById("leerImg"); 
const leerPdf = document.getElementById("leerPdf");

leerImg.addEventListener("click",()=>{
    fetch("../Web/HTML/Imagenes/MV.png").then(res=>res.blob()).then(img=>{
        document.getElementById("img").src = URL.createObjectURL(img)   
    })
});
leerPdf.addEventListener("click",()=>{
    fetch("../Web/HTML/Imagenes/MV.pdf").then(res=>res.blob()).then(pdf=>{
        document.getElementById("pdf").href = URL.createObjectURL(pdf)   
    })
});