Vue.component("hijo",{
    template:`
    <div class="py-5" bg-success>
        <h4>Componente hijo: {{numero}}</h4>
        <h4>Nombre: {{nombre}}</h4>
    </div>
    `,
    props:["numero"],
    data(){
        return{
            nombre:"Elmigue"
        }
    },
    mounted(){
        this.$emit("nombreHijo", this.nombre)
    }
})