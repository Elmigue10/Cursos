const fileInput = document.getElementById("file");
const img = document.getElementById("img");
const text = document.getElementById("text");

// fileInput.addEventListener("change",(evento)=>{
//     const file = evento.target.files[0]
//     const fileReader = new FileReader()
//     fileReader.readAsText(file)
//     fileReader.addEventListener("Load",(evento)=>{
//         text.textContent = evento.target.result;
//     })
// })
// fileInput.addEventListener("change",(evento)=>{
//     const file = evento.target.files[0]
//     const fileReader = new FileReader()
//     fileReader.readAsDataURL(file)
//     fileReader.addEventListener("Load",(evento)=>{
//         img.setAttribute("src",evento.target.result)
//     })
// })
fileInput.addEventListener("change",(evento)=>{
    const files = evento.target.files[0]
    const fragment = document.createDocumentFragment();
    for (const file of files) {
        const fileReader = new FileReader()
        const img = document.createElement('IMG')
        fileReader.readAsDataURL(file)
        fileReader.addEventListener('load', (e) => {
            img.setAttribute('src', e.target.result)
        })
        fragment.appendChild(img)
    }
    images.appendChild(fragment)
})

const fileInput1 = document.getElementById('file1')
const progress = document.getElementById('progress')

const root = document.documentElement

fileInput1.addEventListener('change', (e) => {
    const file = e.target.files[0]
    const fileReader = new FileReader()
    fileReader.readAsDataURL(file)

    fileReader.addEventListener('progress', (e) => {
        root.style.setProperty('--bar-width', Number.parseInt(e.loaded * 100 / e.total) + '%')
    })

    fileReader.addEventListener('loadend', () => {
        root.style.setProperty('--bar-width', '100%')
    })
})
