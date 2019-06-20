<template>
  <el-container>
    <el-header>
      <h1>Tweets respecto a una serie</h1>
    </el-header>
    <el-main>
      <el-row :gutter="20">
        <!-- <el-col :span="6">
          <el-card class="box-card">
            <h3>Filtro</h3>
            <h5>
              Seleccione uno o
              <br>más series
            </h5>
            <label class="container">
              <input type="checkbox" checked="checked">
              <span class="checkmark"></span> Game of Thrones
            </label>
            <label class="container">
              <input type="checkbox" checked="checked">
              <span class="checkmark"></span> Breaking Bad
            </label>
            <label class="container">
              <input type="checkbox" checked="checked">
              <span class="checkmark"></span> Chernobyl
            </label>
            <br>
            <label class="button">Filtrar.</label>
          </el-card>
        </el-col>-->
        <el-col :span="24">
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
                    y: 80,
                    floating: true,
                    borderWidth: 1,
                    shadow: true,
                },
            },
            seriesInfo: [],
        }
    },
    methods: {
        getSerie() {
            axios.get('http://localhost:8080/series').then(response => {
                this.seriesInfo = response.data
                for (var serie of this.seriesInfo) {
                    if (serie.estadisticaTweetSerie != null) {
                        this.chartOptions.xAxis.categories.push(serie.nombre)
                        // console.log(serie.nombre)
                        this.chartOptions.series[0].data.push(
                            serie.estadisticaTweetSerie.nroTweetsPositivos
                        )
                        this.chartOptions.series[1].data.push(
                            serie.estadisticaTweetSerie.nroTweetsNeutros
                        )
                        this.chartOptions.series[2].data.push(
                            serie.estadisticaTweetSerie.nroTweetsNegativos
                        )
                    }
                }
            })
        },
    },
    created() {
        this.getSerie()
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