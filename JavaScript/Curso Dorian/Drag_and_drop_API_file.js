const fileInput = document.getElementById("file")
const dropZone = document.getElementById("drop-zone")

dropZone.addEventListener("click",()=>fileInput.click())

dropZone.addEventListener("dragleave",(evento) =>{
    evento.preventDefault()
    dropZone.classList.remove("drop-zone--active")
})
dropZone.addEventListener("dragdrop",(evento) =>{
    evento.preventDefault()
    console.log(evento.dataTransfer);
})
