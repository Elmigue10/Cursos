    let persona = {
        nombre: "Miguel",
        apellido : "Valbuena",
        id: 9,
        nombreCompleto : function(){
            return `${this.nombre} ${this.apellido}`
        }
    }

    persona.nombreCompleto()