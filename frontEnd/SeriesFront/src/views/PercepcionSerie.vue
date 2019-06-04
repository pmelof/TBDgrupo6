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
            <h5>Seleccione una o más series</h5>
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
export default {
    data() {
        return {
            chartOptions: {
                series: [
                    {
                        name: 'Positiva',
                        data: [107, 31, 635, 203, 2],
                        color: 'green',
                    },
                    {
                        name: 'Neutra',
                        data: [133, 156, 947, 408, 6],
                        color: 'grey',
                    },
                    {
                        name: 'Negativa',
                        data: [814, 841, 3714, 727, 31],
                        color: 'red',
                    },
                ],
                chart: {
                    renderTo: 'container',
                    type: 'bar',
                },
                title: {
                    text: 'Percepción de series',
                },
                subtitle: {
                    text:
                        '(estadísticas obtenidas de la red social Twitter)',
                },
                xAxis: {
                    categories: [
                        'Game of Thrones',
                        'Breaking Bad',
                        'Chernobyl',
                        'BoJack Horseman',
                        'The Walking Dead',
                    ],
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
        }
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
</style>
