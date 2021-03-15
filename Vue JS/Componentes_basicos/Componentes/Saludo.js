Vue.component("saludo",{
    template:`
    <div>
        <h1>Saludo estatico</h1>
        <h1>{{saludo}}</h1>
    </div>`,
    data(){
        return{
            saludo:"Hola desde Vue"
        }
    }
})
