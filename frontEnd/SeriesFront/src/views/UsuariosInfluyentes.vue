<template>
  <el-container>
    <el-header>
      <h1>Tuiteros más influyentes por serie</h1>
    </el-header>
    <el-main>
      <el-row :gutter="20">
        <el-col :span="6">
          <el-card class="box-card">
            <h3>Filtro</h3>
            <h5>
              Seleccione una serie
            </h5>
            <div id="radio">
                <el-radio-group v-model="radio">
                  <el-radio v-for="serie in this.seriesInfo" :label="serie.nombre" :key="serie.nombre">
                    <InfoSeries :nombreSerie="serie.nombre">{{serie.nombre}}</InfoSeries>
                  </el-radio>
                </el-radio-group>
            </div>
            <br>
            <el-button
              type="primary"
              icon="el-icon-search"
              v-on:click="updateChart"
              :disabled="desactivarBoton"
              >Mostrar datos
            </el-button>
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
            chartOptions: {
                series: [
                    {
                        name: 'Número de seguidores',
                        data: [],
                        color: '#2f7ed8',
                    },
                ],
                chart: {
                    renderTo: 'container',
                    type: 'bar',
                    height: 650,
                },
                title: {
                    text: 'Tuiteros más influyentes por serie: ',
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
                        text: 'Número de seguidores',
                        align: 'high',
                    },
                    labels: {
                        overflow: 'justify',
                    },
                },
                tooltip: {
                    valueSuffix: ' seguidores',
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
                    y: 200,
                    floating: true,
                    borderWidth: 1,
                    shadow: true,
                },
            },
            seriesInfo: [],
            radio: '',
            desactivarBoton: true,
        }
    },
    methods: {
        initChart() {
            this.desactivarBoton = true

            axios.get('http://localhost:8080/series').then(response => {
                this.seriesInfo = response.data

                var nombreSerie = this.seriesInfo[0].nombre
                this.radio = nombreSerie
                this.chartOptions.title.text = 'Tuiteros más influyentes por serie: '.concat(nombreSerie)
                var nombreSerieFinal = nombreSerie.replace(/ /g, "_")

                axios.get('http://localhost:8080/neo4j/' + nombreSerieFinal + '/top=5').then(response => {
                    var tuiteroInfo = response.data

                    var largo = tuiteroInfo.length
                    var i = 0

                    while (i < largo) {
                        this.chartOptions.xAxis.categories.push(tuiteroInfo[i].userName)
                        this.chartOptions.series[0].data.push(tuiteroInfo[i].followers)
                        i++
                    }

                    this.desactivarBoton = false
                })
            })
        },

        updateChart() {
            this.desactivarBoton = true

            this.chartOptions.xAxis.categories.length = 0
            this.chartOptions.series[0].data.length = 0
            
            var nombreSerie = this.radio
            this.chartOptions.title.text = 'Tuiteros más influyentes por serie: '.concat(nombreSerie)
            var nombreSerieFinal = nombreSerie.replace(/ /g, "_")

            axios.get('http://localhost:8080/neo4j/' + nombreSerieFinal + '/top=5').then(response => {
                var tuiteroInfo = response.data

                var largo = tuiteroInfo.length
                var i = 0

                while (i < largo) {
                    this.chartOptions.xAxis.categories.push(tuiteroInfo[i].userName)
                    this.chartOptions.series[0].data.push(tuiteroInfo[i].followers)
                    i++
                }

                this.desactivarBoton = false
            })
        }

        ///////////////////////////////

        // INTENTO DE CARGAR LOS DATOS DE FORMA SINCRONA. LOS ARREGLOS SERIES.DATA DEL CHART SE ACTUALIZAN PERO POR ALGUNA RAZON EL CHART NO SE REDIBUJA.

        /* async getUsuarios() {
            try {
                await this.getSeries()
            } catch(error) {
                console.log(error)
            }

            this.chartOptions.xAxis.length = 0
            this.chartOptions.series[0].data.length = 0
            this.chartOptions.series[1].data.length = 0
            this.chartOptions.series[2].data.length = 0
            this.chartOptions.series[3].data.length = 0
            this.chartOptions.series[4].data.length = 0

            var nroSeries = this.seriesInfo.length

            var i = 0
            for (i = 0; i < nroSeries; i++) {
                this.chartOptions.xAxis.categories.push("-")
                this.chartOptions.series[0].data.push(0)
                this.chartOptions.series[1].data.push(0)
                this.chartOptions.series[2].data.push(0)
                this.chartOptions.series[3].data.push(0)
                this.chartOptions.series[4].data.push(0)
            }

            var nombreSerieFinal = ''

            var indiceSerie = 0
            for (var serie of this.seriesInfo) {
                this.checkList.push(serie.nombre)
                this.chartOptions.xAxis.categories[indiceSerie] = serie.nombre
                nombreSerieFinal = serie.nombre.replace(/ /g, "_")
                this.getUsuariosSerie(nombreSerieFinal, indiceSerie)
                indiceSerie++
            }
        },

        getSeries() {
            return axios.get('http://localhost:8080/series').then(response => {
                this.seriesInfo = response.data
            })
        },

        getUsuariosSerie(nombreSerieFinal, indiceSerie) {
            axios.get('http://localhost:8080/neo4j/' + nombreSerieFinal + '/top=5').then(response => {
                var tuiteroInfo = response.data

                var largo = tuiteroInfo.length
                var i = 0

                while (i < largo) {
                    this.chartOptions.series[i].data[indiceSerie] = tuiteroInfo[i].followers
                    i++
                }

                while (i < 5) {
                    this.chartOptions.series[i].data[indiceSerie] = 0
                    i++
                }
            })
        } */

        ///////////////////////////////

        // LO SIGUIENTE FUNCIONA CARGANDO LOS TUITEROS DE TODAS LAS SERIES, PERO REQUIERE TRABAJAR DE FORMA ASINCRONA, POR LO QUE ES MUY, MUY LENTO.

        /* async getUsuarios() {
            try {
                await this.getSeries()
            } catch(error) {
                console.log(error)
            }

            this.chartOptions.xAxis.length = 0
            this.chartOptions.series[0].data.length = 0
            this.chartOptions.series[1].data.length = 0
            this.chartOptions.series[2].data.length = 0
            this.chartOptions.series[3].data.length = 0
            this.chartOptions.series[4].data.length = 0

            var nombreSerieFinal = ''

            for (var serie of this.seriesInfo) {
                this.checkList.push(serie.nombre)
                this.chartOptions.xAxis.categories.push(serie.nombre)
                nombreSerieFinal = serie.nombre.replace(/ /g, "_")
                try {
                    await this.getUsuariosSerie(nombreSerieFinal)
                } catch(error) {
                    console.log(error)
                }
            }
        },

        getSeries() {
            return axios.get('http://localhost:8080/series').then(response => {
                this.seriesInfo = response.data
            })
        },

        getUsuariosSerie(nombreSerieFinal) {
            return axios.get('http://localhost:8080/neo4j/' + nombreSerieFinal + '/top=5').then(response => {
                var tuiteroInfo = response.data

                var largo = tuiteroInfo.length
                var i = 0
                while (i < largo) {
                    this.chartOptions.series[i].data.push(
                        tuiteroInfo[i].followers
                    )
                    i++
                }

                while (i < 5) {
                    this.chartOptions.series[i].data.push(0)
                    i++
                }
            })
        } */
    },
    created() {
        this.initChart()

        // PARA LOS METODOS COMENTADOS ARRIBA
        // this.getUsuarios()
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