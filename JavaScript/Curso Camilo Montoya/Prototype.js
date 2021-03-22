function miObejto(nombre, apellido){
    this.nombre = nombre
    this.apellido = apellido
    this.getFullName = function(){
        return `${this.nombre} ${this.apellido}`
    }
}

let persona = new miObejto("Miguel", "Valbuena")

let personaJSON = {
    nombre: "Miguel",
    apellido: "Valbuena",
    getFullName(){}
}

miObjeto.prototype.nombre = "void"
miObjeto.prototype.apellido = "void"
let persona = new miObejto("Miguel")
