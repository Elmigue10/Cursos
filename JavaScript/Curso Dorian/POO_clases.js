class Persona{
    constructor(nombre, apellido, edad){
        this.nombre=nombre;
        this.apellido=apellido;
        this.edad=edad;
    }
    saludar(){
        return `Hola ${this.nombre} ${this.apellido}, tienes ${this.edad}`;
    }
}

const Miguel= new Persona("Miguel", "Valbuena", 19);
const Pepito= new Persona("Pepito","Perez",25);
Miguel.saludar();
Pepito.saludar();