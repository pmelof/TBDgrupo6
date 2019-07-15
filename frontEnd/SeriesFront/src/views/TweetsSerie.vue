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
              Seleccione una serie marcando la casilla 
              Desmarque la casilla para escoger otra
            </h5>
            <div id="radio">
                <el-checkbox-group v-model="checkbox" :max="1">
                  <el-checkbox v-for="serie in this.seriesInfo" :label="serie.nombre" :key="serie.nombre">
                    <InfoSeries :nombreSerie="serie.nombre">{{serie.nombre}}</InfoSeries>
                  </el-checkbox>
                </el-checkbox-group>
            </div>
            <br>
            <el-button
            type="primary"
            icon="el-icon-search"
            v-on:click="updateChart"
            :disabled="desactivarBoton"
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
import Highcharts from 'highcharts'
import exportingInit from 'highcharts/modules/networkgraph.js'
import InfoSeries from '@/components/InfoSeries.vue'
exportingInit(Highcharts)

export default {
    components: {
        InfoSeries,
    },
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
                    link: {
                        width: 3,
                    },
                    data: [],
                    nodes: [],
                }],
                chart: {
                    type: 'networkgraph',
                    marginTop: 80
                },
                title: {
                        text: 'Tuits sobre una serie'
                    },
                subtitle: {
                    text: '(estadísticas obtenidas de la red social Twitter)<br>Mayor tamaño del nodo denota mayor <b>número de seguidores</b>'
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
                tooltip: {
                    enabled: true,
                    useHTML: true,
                    formatter: function () {
                        var texto = '';
                        if (this.point.esSerie == false) {
                            texto = texto.concat('<b>Número de seguidores del tuitero:</b> ' + this.point.seguidores + '<br>');
                            texto = texto.concat('<b>Mensaje:</b> ' + this.point.mensaje + '<br>');
                        } else {
                            texto = texto.concat('<b>(Serie)</b>');
                        }
                        return texto;
                    }
                }
            },
            seriesInfo: [],
            checkbox: [],
            desactivarBoton: true,
            nodoSerie: {},
        }
    },
    methods: {
        async initChart() {
            this.desactivarBoton = true

            try {
                await this.getSeries()
            } catch(error) {
                console.log(error)
            }

            var nombreSerie = this.seriesInfo[0].nombre
            this.checkbox.push(nombreSerie)
            this.chartOptions.title.text = 'Tuits sobre una serie: '.concat(nombreSerie)
            var nombreSerieFinal = nombreSerie.replace(/ /g, "_")

            this.nodoSerie = {esSerie: true, id: nombreSerie, marker: {radius: 30}}
            this.chartOptions.series[0].nodes.push(this.nodoSerie)

            axios.get('http://localhost:8080/neo4j/' + nombreSerieFinal).then(response => {
                var tuitsInfo = response.data

                var maxFollowers = 0
                for (var tuit of tuitsInfo) {
                    if (tuit.followers > maxFollowers) {
                        maxFollowers = tuit.followers
                    }
                }

                for (var tuit of tuitsInfo) {
                    var tamanoNodo = (tuit.followers / maxFollowers) * 30
                    var nodoUsuario = {esSerie: false, id: tuit.userName, color: '#C74ABF', marker: {radius: tamanoNodo}, seguidores: tuit.followers, mensaje: tuit.text}

                    this.chartOptions.series[0].data.push({from: this.nodoSerie.id, to: nodoUsuario.id})

                    this.chartOptions.series[0].nodes.push(nodoUsuario)
                }

                this.desactivarBoton = false
                this.nodoSerie = {}
            })
        },

        updateChart() {
            this.desactivarBoton = true

            this.chartOptions.series[0].data.length = 0
            this.chartOptions.series[0].nodes.length = 0
            
            var nombreSerie = this.checkbox[0]
            this.chartOptions.title.text = 'Tuits sobre una serie: '.concat(nombreSerie)
            var nombreSerieFinal = nombreSerie.replace(/ /g, "_")

            this.nodoSerie = {esSerie: true, id: nombreSerie, marker: {radius: 30}}
            this.chartOptions.series[0].nodes.push(this.nodoSerie)

            axios.get('http://localhost:8080/neo4j/' + nombreSerieFinal).then(response => {
                var tuitsInfo = response.data

                var maxFollowers = 0
                for (var tuit of tuitsInfo) {
                    if (tuit.followers > maxFollowers) {
                        maxFollowers = tuit.followers
                    }
                }

                for (var tuit of tuitsInfo) {
                    var tamanoNodo = (tuit.followers / maxFollowers) * 30
                    var nodoUsuario = {esSerie: false, id: tuit.userName, color: '#C74ABF', marker: {radius: tamanoNodo}, seguidores: tuit.followers, mensaje: tuit.text}

                    this.chartOptions.series[0].data.push({from: this.nodoSerie.id, to: nodoUsuario.id})

                    this.chartOptions.series[0].nodes.push(nodoUsuario)
                }

                this.desactivarBoton = false
                this.nodoSerie = {}
            })
        },

        getSeries() {
            return axios.get('http://localhost:8080/series').then(response => {
                this.seriesInfo = response.data
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
    height: 52vh;
    overflow-y: auto;
}

.el-checkbox-group {
    display: flex;
    flex-direction: column;
    align-items: baseline;
    padding-left: 5%;
}

.el-checkbox-__label {
    padding-left: 0;
}

.el-container {
    padding: 30px;
}
.box-card{
    overflow-y: auto;
}

.el-button {
    width: 100%;
}
</style>