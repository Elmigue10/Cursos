<template>
    <div>
        <h1>Galería:</h1>

        <router-link :to="{name:'fotos', params:{id : item}}" 
        v-for="(item, index) of fotosArreglo" :key="index">
            <button class="btn-primary">Foto {{item}}</button>
        </router-link>

        <Foto />

        <button class="btn-danger" @click="home">Home</button>
        <br>
        <br>
        <button class="btn-danger" @click="anterior">Anterior</button>
        <button class="btn-danger" @click="siguiente">Siguiente</button>
    </div>
</template>

<script>

    import Foto from "@/components/Fotografia.vue"
export default {
    name:"Fotos",
    components:{
        Foto
    },
    data(){
        return{
            fotosArreglo:[1,2,3]
        }
    },
    methods: {
    
        home () { 
            this.$router.push("/")
        },
        anterior () { 
            this.$router.go(-1)
        },
        siguiente(){
            this.$router.go(1)
        }
    }
}
</script>