const store = new Vuex.Store({
    state:{
        numero:10,
        cursos:[]
    },
    mutations:{
        aumentar(state){
            state.numero ++
            //this.state.numero ++ sin el parametro
        },
        disminuir(state, n){
            state.numero -= n
        },
        llenarCursos (state, cursosAccion) {
            state.cursos = cursosAccion
        }
    },
    actions:{
        obtenerCursos:async function ({commit}) {
            const data = await fetch("cursos.json")
            const cursos = await data.json()
            commit("llenarCursos",cursos)
        }
    }
})

const app = new Vue ({
    el:"#app",
    store: store
})