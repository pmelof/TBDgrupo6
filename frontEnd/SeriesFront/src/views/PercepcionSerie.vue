<template>
  <el-container>
    <el-header>
      <h1>Percepción de series</h1>
    </el-header>
    <el-main>
      <el-row :gutter="20">
        <el-col :span="6">
          <el-card class="box-card">
            <h3>Filtro</h3>
            <h5>
              Seleccione una o
              <br>más series
            </h5>
            <div id="checkbox">
                <el-checkbox-group v-model="checkList" @change="handleFilterChange">
                  <el-checkbox v-for="serie in this.seriesInfo" :label="serie.nombre" :key="serie.nombre">
                    <InfoSeries :nombreSerie="serie.nombre">{{serie.nombre}}</InfoSeries>
                  </el-checkbox>
                </el-checkbox-group>
            </div>
            <br>
            <el-row :gutter="5">
                <el-col :span="12">
                    <el-button
                    type="primary"
                    icon="el-icon-search"
                    v-on:click="updateChart"
                    >Filtrar</el-button>    
                </el-col>

                <el-col :span="12">
                    <el-button
                    type="primary"
                    v-on:click="removeFilter"
                    >Limpiar</el-button>
                </el-col>
            </el-row>
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
                        name: 'Positiva',
                        data: [],
                        color: '#56FF84',
                    },
                    {
                        name: 'Neutra',
                        data: [],
                        color: '#FFEA9E',
                    },
                    {
                        name: 'Negativa',
                        data: [],
                        color: '#FF9291',
                    },
                ],
                chart: {
                    renderTo: 'container',
                    type: 'bar',
                    height: 650,
                },
                title: {
                    text: 'Percepción de series',
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
                        text: 'Número de tuits',
                        align: 'high',
                    },
                    labels: {
                        overflow: 'justify',
                    },
                },
                tooltip: {
                    valueSuffix: ' tuits',
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
                    y: 120,
                    floating: true,
                    borderWidth: 1,
                    shadow: true,
                },
            },
            seriesInfo: [],
            checkList: []
        }
    },
    methods: {
        getSeries() {
            this.chartOptions.xAxis.categories.length = 0
            this.chartOptions.series[0].data.length = 0
            this.chartOptions.series[1].data.length = 0
            this.chartOptions.series[2].data.length = 0

            axios.get('http://localhost:8080/series').then(response => {
                this.seriesInfo = response.data
                this.seriesInfo.sort(this.compare)

                for (var serie of this.seriesInfo) {
                    this.chartOptions.xAxis.categories.push(serie.nombre)
                    if (serie.estadisticaTweetSerie != null) {
                        this.chartOptions.series[0].data.push(
                            serie.estadisticaTweetSerie.nroTweetsPositivos
                        )
                        this.chartOptions.series[1].data.push(
                            serie.estadisticaTweetSerie.nroTweetsNeutros
                        )
                        this.chartOptions.series[2].data.push(
                            serie.estadisticaTweetSerie.nroTweetsNegativos
                        )
                    } else {
                        this.chartOptions.series[0].data.push(0)
                        this.chartOptions.series[1].data.push(0)
                        this.chartOptions.series[2].data.push(0)
                    }

                    this.checkList.push(serie.nombre)
                }
            })
        },

        compare(a, b) {
            if ((a.estadisticaTweetSerie == null) || (b.estadisticaTweetSerie == null)) {
                return 1
            }

            const nroTweetsA = a.estadisticaTweetSerie.nroTweets
            const nroTweetsB = b.estadisticaTweetSerie.nroTweets

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
            this.chartOptions.series[1].data.length = 0
            this.chartOptions.series[2].data.length = 0

            for (var serie of this.seriesInfo) {
                var poner = false

                for (var nombreSerie of this.checkList) {
                    if (nombreSerie == serie.nombre) {
                        poner = true
                        break
                    }
                }

                if (poner == true) {
                    this.chartOptions.xAxis.categories.push(serie.nombre)
                    if (serie.estadisticaTweetSerie != null) {
                        this.chartOptions.series[0].data.push(
                            serie.estadisticaTweetSerie.nroTweetsPositivos
                        )
                        this.chartOptions.series[1].data.push(
                            serie.estadisticaTweetSerie.nroTweetsNeutros
                        )
                        this.chartOptions.series[2].data.push(
                            serie.estadisticaTweetSerie.nroTweetsNegativos
                        )
                    } else {
                        this.chartOptions.series[0].data.push(0)
                        this.chartOptions.series[1].data.push(0)
                        this.chartOptions.series[2].data.push(0)
                    }
                }
            }
        },

        removeFilter() {
            this.checkList.length = 0
            this.getSeries()
        },

        handleFilterChange(val) {
            if (this.checkList.length == 0) {
                this.getSeries()
            }
        },
    },
    created() {
        this.getSeries()
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
    padding: 10px 0px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 15px;
}

.el-checkbox-group {
    display: flex;
    flex-direction: column;
    align-items: baseline;
    padding-left: 5%;
}

.el-button {
    width: 100%;
}

#checkbox {
    height: 50vh;
    overflow-y: auto;
}

.el-container {
    padding: 30px;
}

.box-card{
    overflow-y: auto;
}

</style>