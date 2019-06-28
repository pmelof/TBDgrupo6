<template>
  <el-container>
    <el-header>
      <h1>Tweets sobre una serie</h1>
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
import Highcharts from 'highcharts'
import exportingInit from 'highcharts/modules/networkgraph.js'
exportingInit(Highcharts)


////////////////////////////

Highcharts.addEvent(
    Highcharts.seriesTypes.networkgraph,
    'afterSetOptions',
    function (e) {
        var colors = Highcharts.getOptions().colors,
            i = 0,
            nodes = {};
        e.options.data.forEach(function (link) {

            if (link[0] === 'Proto Indo-European') {
                nodes['Proto Indo-European'] = {
                    id: 'Proto Indo-European',
                    marker: {
                        radius: 20
                    }
                };
                nodes[link[1]] = {
                    id: link[1],
                    marker: {
                        radius: 10
                    },
                    color: colors[i++]
                };
            } else if (nodes[link[0]] && nodes[link[0]].color) {
                nodes[link[1]] = {
                    id: link[1],
                    color: nodes[link[0]].color
                };
            }
        });

        e.options.nodes = Object.keys(nodes).map(function (id) {
            return nodes[id];
        });
    }
);

////////////////////////////


export default {
    data() {
        return {
            chartOptions: {
                series: [{
                    marker: {
                        radius: 13
                    },
                    dataLabels: {
                        enabled: true,
                        textPath: {
                            enabled: false
                        },
                        linkFormat: '',
                        allowOverlap: true
                    },
                    data: [

                    ]
                }],
                chart: {
                    type: 'networkgraph',
                    marginTop: 80
                },
                title: {
                        text: 'Tweets sobre una serie'
                    },
                subtitle: {
                    text: '(estadísticas obtenidas de la red social Twitter)',
                },
                plotOptions: {
                    networkgraph: {
                        keys: ['from', 'to'],
                        layoutAlgorithm: {
                            enableSimulation: true,
                            integration: 'verlet',
                            linkLength: 100
                        }
                    }
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
                 this.chartOptions.title.text = 'Tweets sobre una serie: '.concat(nombreSerie)
                 var nombreSerieFinal = nombreSerie.replace(/ /g, "_")

                 axios.get('http://localhost:8080/neo4j/' + nombreSerieFinal).then(response => {
                     var relacionInfo = response.data
                     var arreglo=[]

                     var largo = relacionInfo.length
                     var i=0

                     while (i < largo) {
                         arreglo.push(nombreSerieFinal)
                         arreglo.push(relacionInfo[i].userName)
                         //this.chartOptions.xAxis.categories.push(tuiteroInfo[i].userName)
                         this.chartOptions.series[0].data.push(arreglo)
                         arreglo=[]
                         i++
                     }
                     this.desactivarBoton = false
                 })
             })
         },
         updateChart() {
             this.desactivarBoton = true

             //this.chartOptions.xAxis.categories.length = 0
             this.chartOptions.series[0].data.length = 0

             var nombreSerie = this.radio
             console.log(nombreSerie)
             this.chartOptions.title.text = 'Tweets sobre una serie: '.concat(nombreSerie)
             var nombreSerieFinal = nombreSerie.replace(/ /g, "_")

             axios.get('http://localhost:8080/neo4j/' + nombreSerieFinal).then(response => {
                  var relacionInfo = response.data
                  var arreglo=[]

                     var largo = relacionInfo.length
                     var i=0

                     while (i < largo) {
                         arreglo.push(nombreSerieFinal)
                         arreglo.push(relacionInfo[i].userName)
                         console.log(arreglo)
                         //this.chartOptions.xAxis.categories.push(tuiteroInfo[i].userName)
                         this.chartOptions.series[0].data.push(arreglo)
                         arreglo=[]
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
    overflow-y: auto;
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