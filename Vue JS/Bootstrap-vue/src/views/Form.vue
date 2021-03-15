<template>
    <div class="mt-5">
        <h1>Formularios</h1>
        <form>
            <b-row>
                <b-col md="3">
                    <b-form-input type="number" v-model="numero" placeholder="numero"
                        :state="comprobar"
                    ></b-form-input> 
                    <small>Minimo 4 numeros.</small>
                    <b-form-input type="text" v-model="texto" placeholder="texto"></b-form-input> 
                    <p>numero : {{numero}}</p>
                    <p>texto : {{texto}}</p>
                </b-col>
                <b-col md="3">
                    <b-form-select v-model="select" :options="options"></b-form-select>
                    <p>Seleccion: {{select}}</p>
                </b-col>
                <b-col md="3">
                    <b-form-radio-group v-model="radio" :options="options"></b-form-radio-group>
                    <p>Seleccion: {{radio}}</p>
                </b-col>
                <b-col md=3>
                    <b-form-checkbox-group v-model="check" :options="options"></b-form-checkbox-group>
                    <p>Seleccion : {{check}}</p>
                </b-col>
            </b-row>
        </form>
    </div>
</template>

<script>
    export default {
        name:"Form",
        data(){
            return{
                texto:"",
                numero:"",
                select:null,
                options:[
                    {value:"azul", text:"Azul"},
                    {value:"rojo", text:"Rojo"},
                    {value:"verde", text:"Verde"}
                ],
                radio:null,
                check:[]
            }
        },
        computed:{
            comprobar(){
                return this.numero.length > 3 ? true : false
            }
        }
    }
</script>