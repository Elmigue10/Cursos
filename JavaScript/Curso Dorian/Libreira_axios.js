const button= document.getElementById("button");

button.addEventListener("click",()=>{
    axios({
        method:"GET",
        url:"https://jsonplaceholder.typicode.com/users"
    })
    .then(res=>{
        const list = document.getElementById("list");
        const fragment = document.createElement()
        for (const userInfo of res.data){
            const listItem=document.createElement("LI");
            listItem.textContent= `${userInfo.id} - ${userInfo.name}`
            fragment.appendChild(listItem)
        }
        list.appendChild(fragment)
    }).catch(error=>console.log(error));
});


button.addEventListener("click",()=>{
    axios({
        method:"POST",
        url:"https://jsonplaceholder.typicode.com/posts",
        data:{
            title:"New post",
            body:"Lorem asda gsfd rera sfacsd",
            userId:1
        }
    }).then(res=>console.log(res.data))
    .catch(error=>console.log(error));
})