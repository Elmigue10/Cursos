import { Component } from "@angular/core"

@Component({
    moduleId: module.id,
    selector: "app-storage",
    templateUrl: "storage.component.html"
})

export class StorageComponent{
    
    constructor(){
        this.guardarLocalStorage()

        this.obtenerLocalStorage()
    }

    obtenerLocalStorage(){
        
        let nombre = localStorage.getItem("nombre")
        let persona = JSON.parse(localStorage.getItem("persona"))

    }

    guardarLocalStorage(){

        let nombre:string = "Miguel"
        let persona = {
            nombre:"Juan",
            edad:18,
            coords:{
                lar:10,
                lng:-10
            }
        }    

        localStorage.setItem("nombre", nombre)
        localStorage.setItem("persona", JSON.stringify(persona))

    }

}