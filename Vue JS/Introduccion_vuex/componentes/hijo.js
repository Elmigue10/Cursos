Vue.component ("hijo",{
    template:`
    <div>
        <button @click="aumentar">+</button>
        <button @click="disminuir(5)">-</button>
        <h1>numero {{numero}}</h1>
    </div>
    `,
    computed:{
        ...Vuex.mapState(
            ["numero"]
        )
    },
    methods:{
        ...Vuex.mapMutations(
            ["aumentar","disminuir"]
        )
    }
})