    const store = new Vuex.Store({
        state:{
            numero:10
        },
        mutations:{
            aumentar(state){
                state.numero ++
                //this.state.numero ++ sin el parametro
            },
            disminuir(state, n){
                state.numero -= n
            }
        }
    })
    
    const app = new Vue ({
        el:"#app",
        store: store
    })