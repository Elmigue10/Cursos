Vue.component ("hijo",{
    template:`
    <div>
        <button @click="aumentar">+</button>
        <button @click="disminuir(5)">-</button>
        <button @click="obtenerCursos">Obtener curos</button>
        <h1>numero {{numero}}</h1>
        <ul>
            <li v-for="item of cursos">{{item.nombre}}</li>
        </ul>
    </div>
    `,
    computed:{
        ...Vuex.mapState(["numero","cursos"])
    },
    methods:{
        ...Vuex.mapMutations(["aumentar","disminuir"]),
        ...Vuex.mapActions(["obtenerCursos"])
    }
})