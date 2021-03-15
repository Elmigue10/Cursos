console.log(innerWidth)

const title = document.getElementById("title")
const mql = matchMedia('(min-width:400px) and (orientation: landscape)')

console.log(mql)

const applyMatchMedia = mql => {
    mql.matches ?
        //NO HACER ESTO NUNCA :)
        //NO HACER ESTO NUNCA
        // document.body.style.backgroundColor = 'red'
        //ESTO SI
        title.classList.add('clase que sea');
        //NO HACER ESTO NUNCA :)
        //NO HACER ESTO NUNCA
        document.body.style.backgroundColor = 'royalblue'
}

addEventListener('resize', () => applyMatchMedia(mql))
addEventListener("DOMContentLoaded",()=> applyMatchMedia(mql))