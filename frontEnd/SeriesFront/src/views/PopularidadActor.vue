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
                        name: 'Popularidad relativa',
                        data: [133, 156, 947],
                        color: 'blue',
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
                    text:
                        '(estadísticas obtenidas de la red social Twitter)',
                },
                xAxis: {
                    categories: [
                        'Peter Dinklage, de Game of Thrones',
                        'Emilia Clarke, de Game of Thrones',
                        'Bryan Cranston, de Breaking Bad',
                    ],
                    title: {
                        text: null,
                    },
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Popularidad relativa (calculada en base al número de tuits)',
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
