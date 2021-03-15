const app = new Vue({
    el:"#app",
    data:{
        titulo:"Hola mundo con Vue",
        frutas:[
            {nombre:"manzana", cantidad:10},
            {nombre:"pera", cantidad:20},
            {nombre:"platano", cantidad:0}
        ],
        nuevaFruta:"",
        total:0
    },
    methods:{
        agregarFruta(){
            console.log("Diste click")
            this.frutas.push({
                nombre:this.nuevaFruta,
                cantidad:"0"
            })
            this.nuevaFruta=""
        }
    },
    computed:{
        sumarFrutas(){
            this.total=0
            for (fruta of this.frutas) {       
                this.total = this.total + fruta.cantidad
            }
            return this.total
        }
    }
})