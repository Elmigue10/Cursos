const app = new Vue ({
    el:"#app",
    data:{
        mensaje:"Hola soy el migue",
        contador:0
    },
    computed:{
        invertido(){
            return this.mensaje.split("").reverse().join("")
        },
        color(){
            return {
                "bg-success":this.contador <= 10,
                "bg-warning":this.contador > 10 && this.contador <=20,
                "bg-danger":this.contador > 20 && this.contador <=40,
                "bg-dark":this.contador > 40
            }
        }
    }
})