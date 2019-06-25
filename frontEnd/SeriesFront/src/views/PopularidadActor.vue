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
            <div id="checkbox">
                <el-checkbox-group v-model="checkList" @change="handleFilterChange">
                  <el-checkbox v-for="personaje in this.personajesInfo" :label="personaje.actor.nombre" :key="personaje.actor.nombre">
                    <InfoSeries :nombreSerie="personaje.actor.nombre">{{personaje.actor.nombre}}</InfoSeries>
                  </el-checkbox>
                </el-checkbox-group>
            </div>
            <br>
            <el-button
              type="primary"
              icon="el-icon-search"
              v-on:click="updateChart"
              >Filtrar</el-button>
            <br>
            <br>
            <el-button
              type="primary"
              v-on:click="removeFilter"
              >Quitar filtro</el-button>
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
import InfoSeries from '@/components/InfoSeries.vue'
export default {
    components: {
        InfoSeries,
    },
    data() {
        return {
            actores: [],
            chartOptions: {
                series: [
                    {
                        name: 'Popularidad relativa',
                        data: [],
                        color: '#2f7ed8',
                    },
                ],
                chart: {
                    renderTo: 'container',
                    type: 'bar',
                    height: 1000,
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
                    labels: {
                        step: 1,
                    }
                },
                yAxis: {
                    min: 0,
                    title: {
                        text:
                            'Popularidad relativa (calculada en base al número de tuits)',
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
                    y: 100,
                    floating: true,
                    borderWidth: 1,
                    shadow: true,
                },
            },
            personajesInfo: [],
            checkList: [],
        }
    },
    computed: {},
    methods: {
        getActores() {
            this.chartOptions.xAxis.categories.length = 0
            this.chartOptions.series[0].data.length = 0

            axios.get('http://localhost:8080/personajes').then(response => {
                this.personajesInfo = response.data
                this.personajesInfo.sort(this.compare)

                for (var personaje of this.personajesInfo) {
                    personaje.actor.nombre = personaje.actor.nombre.concat(' | ' + personaje.serie.nombre)
                    this.chartOptions.xAxis.categories.push(personaje.actor.nombre)
                    if (personaje.actor.estadisticaTweetActor != null) {
                        this.chartOptions.series[0].data.push(
                            personaje.actor.estadisticaTweetActor.nroTweets
                        )
                    } else {
                        this.chartOptions.series[0].data.push(0)
                    }

                    this.checkList.push(personaje.actor.nombre)
                }
            })
        },

        compare(a, b) {
            if ((a.actor.estadisticaTweetActor == null) || (b.actor.estadisticaTweetActor == null)) {
                return 1
            }

            const nroTweetsA = a.actor.estadisticaTweetActor.nroTweets
            const nroTweetsB = b.actor.estadisticaTweetActor.nroTweets

            if (nroTweetsA > nroTweetsB) {
                return -1
            } else if (nroTweetsA < nroTweetsB) {
                return 1
            }
            return 0
        },

        updateChart() {
            this.chartOptions.xAxis.categories.length = 0
            this.chartOptions.series[0].data.length = 0

            for (var personaje of this.personajesInfo) {
                var poner = false

                for (var nombreActor of this.checkList) {
                    if (nombreActor == personaje.actor.nombre) {
                        poner = true
                        break
                    }
                }

                if (poner == true) {
                    this.chartOptions.xAxis.categories.push(personaje.actor.nombre)
                    if (personaje.actor.estadisticaTweetActor != null) {
                        this.chartOptions.series[0].data.push(
                            personaje.actor.estadisticaTweetActor.nroTweets
                        )
                    } else {
                        this.chartOptions.series[0].data.push(0)
                    }
                }
            }
        },

        removeFilter() {
            this.checkList.length = 0
            this.getActores()
        },

        handleFilterChange(val) {
            if (this.checkList.length == 0) {
                this.getActores()
            }
        },
    },
    created() {
        this.getActores()
    },
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