class Libro{
    constructor (titulo, autor, año, genero){
        this.titulo=titulo;
        this.autor=autor;
        this.año=año;
        this.genero=genero;
    }
    getautor(){
        return this.autor;
    }
    getgenero(){
        return this.genero;
    }
    libroinfo(){
        return `${this.titulo} es un libro de ${this.genero} escrito por ${this.autor} en el año ${this.año}`;
    }
}

let libros=[];

while (libros.length<3){
    let titulo= prompt("Introduce el titulo del libro");
    let autor= prompt("Introduce el autor del libro");
    let año= prompt("Introduce el año del libro");
    let genero= prompt("Introduce el genero del libro").toLowerCase;

    if(titulo !="" && autor!="" && !isNaN(año) && año.length == 4 && (genero=="aventura"||genero=="terror"||genero=="fantasia")){
        libros.push(new Libro(titulo, autor, año, genero));
    }
}

function mostrarlibros () {
    console.log(libros);
}
function mostrarautores(){
    let autores=[];
    for (const libro of libros){
        autores.push(libro.getautor());
    }
    console.log(autores.sort());
}
function mostrargeneros(){
    const genero = prompt("Introduce un genero");
    for(const libro of libros){
        if(libro.getgenero()==genero){
            console.log(libro.libroinfo);
        }
    }
}

mostrarlibros();
mostrarautores();
mostrargeneros();