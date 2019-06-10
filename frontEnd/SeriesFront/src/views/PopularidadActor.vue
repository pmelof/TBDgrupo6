<template>
  <el-container>
    <el-header>
      <h1>Popularidad de actores de series</h1>
    </el-header>
    <el-main>
      <el-row :gutter="20">
        <el-col :span="6">
          <el-card class="box-card">
            <h3>Filtro</h3>
            <h5>
              Seleccione uno o
              <br>más actores
            </h5>
            <div id="demo">
              <div v-for="actor in chartOptions.xAxis.categories" :key="actor.id">
                <el-checkbox :value="actor" :id="actor" v-model="checked">{{actor}}</el-checkbox>
              </div>
              {{ checked }}
            </div>
            <br>
            <el-button
              type="primary"
              icon="el-icon-search"
              v-on:click="filterByActores()"
              >Filtrar</el-button>
          </el-card>
        </el-col>
        <el-col :span="18">
          <el-card class="box-card">
            <highcharts :options="chartOptions"></highcharts>
          </el-card>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            actores: [],
            actoresFiltrados: [],
            chartOptions: {
                series: [
                    {
                        name: 'Popularidad',
                        data: [],
                        color: '#2f7ed8',
                    },
                ],
                chart: {
                    renderTo: 'container',
                    type: 'bar',
                },
                title: {
                    text: 'Popularidad relativa de actores de series',
                },
                subtitle: {
                    text: '(estadísticas obtenidas de la red social Twitter)',
                },
                xAxis: {
                    categories: [],
                    title: {
                        text: null,
                    },
                },
                yAxis: {
                    min: 0,
                    title: {
                        text:
                            'Popularidad relativa',
                        align: 'high',
                    },
                    labels: {
                        overflow: 'justify',
                    },
                },
                tooltip: {
                    valueSuffix: '',
                },
                plotOptions: {
                    bar: {
                        dataLabels: {
                            enabled: true,
                        },
                    },
                },
                credits: {
                    enabled: false,
                },
                legend: {
                    layout: 'vertical',
                    align: 'right',
                    verticalAlign: 'top',
                    x: -40,
                    y: 80,
                    floating: true,
                    borderWidth: 1,
                    shadow: true,
                },
            },
        }
    },
    computed: {
    },
    methods: {
        getActores() {
            axios.get('http://localhost:8080/actores').then(response => {
                this.actores = response.data
                for (var actor of this.actores) {
                    if (actor.estadisticaTweetActor != null) {
                        this.chartOptions.xAxis.categories.push (
                            actor.nombre
                        )
                        this.chartOptions.series[0].data.push (
                            actor.estadisticaTweetActor.nroTweets
                        )
                    }
                    // console.log(actor.nombre)
                }
                // console.log(this.chartOptions.series[0].data)
            });

            for (var actor of this.actores) {
                this.actoresFiltrados.push(actor)
            }
            
        },
        filterByActores() {
            this.actoresFiltrados.length = 0

            //for (var actor of actoresFiltrados) {
            //    var data_filter = this.actores.filter( element => element.nombre ==actor)
            //}

            this.actoresFiltrados.push(this.actores[0])

            var categorias = []
            var data = []

            for (var actor of this.actoresFiltrados) {
                categorias.push(actor.nombre)
            }

            for (var actor of this.actoresFiltrados) {
                data.push(actor.estadisticaTweetActor.nroTweets)
            }

            this.chartOptions.series.setData(data, false, false)

            this.chartOptions.xAxis.setOptions({xAxis: {categories: categorias}})

            this.chartOptions.redraw()

            // console.log(actor.nombre)
            // console.log(this.chartOptions.series[0].data)
        },
    },
    created() {
        this.getActores()
    }
}
</script>

<style scoped>
.el-card {
    width: 100%;
    height: 80vh;
}
.el-header {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
}
.container {
    display: block;
    position: relative;
    margin-bottom: 12px;
    cursor: pointer;
    font-size: 15px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* Hide the browser's default checkbox */
.container input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
    height: 0;
    width: 0;
}

/* Create a custom checkbox */
.checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #eee;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
    background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.container input:checked ~ .checkmark {
    background-color: #2196f3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
    content: '';
    position: absolute;
    display: none;
}

/* Show the checkmark when checked */
.container input:checked ~ .checkmark:after {
    display: block;
}

/* Style the checkmark/indicator */
.container .checkmark:after {
    left: 9px;
    top: 5px;
    width: 5px;
    height: 10px;
    border: solid white;
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
}

.button {
    background-color: #2196f3;
    border: none;
    border-radius: 2px;
    color: white;
    padding: 10px 20px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
}
</style>