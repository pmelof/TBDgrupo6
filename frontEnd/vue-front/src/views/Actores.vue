<template>
    <div class="container">
    <h1>Listado de actores</h1>
    <ListarActores/>
    </div>
</template>

<script>
import ListarActores from '@/components/ListarActores.vue'

export default {
    name: 'Actores',
    components: {
        ListarActores
    }
}

</script>

