const app = new Vue ({
    el:"#app",
    data: {
        saludo:"El ciclo de vida de Vue"
    },
    beforeCreate(){
        console.log("Before create")
    },
    created(){
        //Al crear los metodos, observadores y eventos, pero aun no accede al DOM.
        //Aun no se puede acceder a "el"
        console.log("Created")
    },
    beforeMount(){
        //Se ejecuta antes de insertar el DOM
        console.log("beforeMount")
    },
    mounted(){
        //Se ejecuta al insertar el DOM
        console.log("Mounted")
    },
    beforeUpdate(){
        //Al detectar un cambio
        console.log("beforeUpdated")
    },
    updated() {
        //Al realizar los cambios
        console.log("updated")
    },
    beforeDestroy(){
        //Antes de destruir la instancia
        console.log("beforeDestroy")
    },
    destroyed(){
        //Se destruye toda la instancia
        console.log("destroyed")
    },
    methods:{
        destruir(){
            this.$destroy()
        }
    }

})