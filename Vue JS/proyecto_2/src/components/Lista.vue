<template>
    <div>
        <ul class="list-group">
            <li v-for="(item, index) of ordenarArray" :key="item.id" @click="aumentar(index)"
            class="list-group-item d-flex justify-content-between align-items-center">
                {{index+1}} - {{item.nombre}}
                <span class="badge badge-primary badge-pill">{{item.cantidad}}</span>
            </li>
        </ul>
        <button value="Reiniciar" class="btn btn-primary btn-block" @click="reiniciar">Reiniciar</button>
    </div>
</template>

<script>

    import {mapState, mapMutations} from "vuex"
    export default {
        name:"Lista",
        computed: {
            ...mapState(["frutas"]),
            ordenarArray(){
                return this.frutas.sort((a,b) => (
                    b.cantidad-a.cantidad
                ))
            }
        },
        methods: {
            ...mapMutations(["aumentar","reiniciar"])
        },
    }
</script>