function getName(){
    return "Miguel"
}

function getLastName(){
    return "Valbuena"
}

function getFullName(){
    const name = getName()
    const lastName = getLastName()
    return `${name} ${lastName}`
}

const fullName = getFullName()

console.log("Nombre completo: "+fullName)