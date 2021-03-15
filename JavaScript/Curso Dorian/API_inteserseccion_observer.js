const boxes = document.querySelectorAll('.box')

const callback = (entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            console.log(entry.target.id, 'is intersecting')
        }
    })
}

const options = {
    // root:
    // rootMargin: '-200px'
    threshold: 0.25
}

const observers = new IntersectionObserver(callback, options)
boxes.forEach(element => observers.observe(element))




const images = document.getElementById('images')
const getImages = () => {
    axios('https://picsum.photos/v2/list?page=3&limit=5')
        .then(res => {
            const fragment = document.createDocumentFragment()
            res.data.forEach(element => {
                const newImage = document.createElement('IMG')
                newImage.src = element.download_url
                fragment.appendChild(newImage)
            })
            images.appendChild(fragment)
            setObserver()
        })
}

const callbacks = (entries) => {
    entries.forEach(entry => {
        if (entry.isIntersecting) {
            getImages()
        } else {
            //quitar animación
        }
    })
}

const setObserver = () => {
    const options = {
        threshold: 0.5
    }

    const observer = new IntersectionObserver(callbacks, options)
    observer.observe(images.lastElementChild)
}

getImages()