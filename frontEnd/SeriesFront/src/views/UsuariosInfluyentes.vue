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
                    text: '(Estadísticas obtenidas de la red social Twitter)',
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

                    while (i < 5) {
                        this.chartOptions.xAxis.categories.push("Sin información")
                        this.chartOptions.series[0].data.push(0)
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
                
                while (i < 5) {
                    this.chartOptions.xAxis.categories.push("Sin información")
                    this.chartOptions.series[0].data.push(0)
                    i++
                }

                this.desactivarBoton = false
            })
        }
    },
    created() {
        this.initChart()
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
#radio {
    height: 58vh;
    overflow-y: auto;
}

.el-container {
    padding: 30px;
}
.box-card{
    overflow-y: auto;
}
</style>