<template>
    <div>
        <div class="container">
            <div class="card">
                <div class="card-body">
                    <div class="form-group">
                        <label for="input1">Nombre</label>
                        <input type="text" class="form-control" id="input1" placeholder="Ingrese nombre del actor" v-model="firstName">
                    </div>
                    <div class="form-group">
                        <label for="input2">Apellido</label>
                        <input type="text" class="form-control" id="input2" placeholder="Ingrese apellido del actor" v-model="lastName">
                    </div> 

                    <!-- Button trigger modal -->
                    <button type="button" :disabled="verificated" @click.prevent="agregarActores()" class="btn btn-warning btn-block" data-toggle="modal" data-target="#exampleModal">
                    Agregar
                    </button>
                    
                    <!-- Modal -->
                    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar Actor</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                El actor se agrego correctamente
                            </div>
                        </div>
                    </div>
                    </div>

                </div>
            </div>
        </div>
    </div>
</template>

<script>

import {mapState,mapActions} from 'vuex';

export default {
    name: 'AgregarActor',
    data() {
        return {
            firstName: '',
            lastName: '',
            validate: 0
        }
    },
    computed: {
        verificated(){
    	if (this.firstName === '' || this.lastName === '') {
            return true
        } else {
            return false
        }
    }
    },
    methods: {
        agregarActores() {
            this.$axios.post("/actors/new",{
                firstName: this.firstName,
                lastName: this.lastName,
            }).then((response) => {
                console.log(response.data);
                this.firstName = '';
                this.lastName = '';
            });
        },
    },
    created() {
    }

}
</script>

<style>
    .card {
        padding: 1%;
    }

    .form {
        display: block;
    }
    .modal-header
    {
        background-color: rgb(247, 194, 68);
    }
    
</style>

