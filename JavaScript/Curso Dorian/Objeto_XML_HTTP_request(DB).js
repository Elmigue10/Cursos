const button = document.getElementById("button");

button.addEventListener("click", ()=>{
    let xhr;
    if(window.XMLHttpRequest) {
        xhr=new XMLHttpRequest();
    }
    else {
        xhr= new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhr.open("GET","https://jsonplaceholder.typicode.com/users");

    xhr.addEventListener("load",(data)=>{

        let dataJSON = JSON.parse(data.target.response);

        const list= document.getElementById("list");

        for(const userInfo of dataJSON){

            const listitem=document.createElement("LI");

            listitem.textContent=`${userInfo.id} - ${userInfo.name}`

            list.appendChild(listitem);
        }
    });

    xhr.send();
});

const form = document.getElementById("form");

form.addEventListener("submit",(evento)=>{
    evento.preventDefault();
});

const senddata = (data) =>{
    if(window.XMLHttpRequest) {
        xhr=new XMLHttpRequest();
    }
    else {
        xhr= new ActiveXObject("Microsoft.XMLHTTP");
    }
    console.log(data);
    xhr.open("POST","marvel.php")
    const formData= new FormData(data);
    xhr.send(formData);
}