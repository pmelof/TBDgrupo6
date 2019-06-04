<template>
  <el-container>
    <el-header>
      <h1>Percepción Serie</h1>
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
                        name: 'Year 1800',
                        data: [107, 31, 635, 203, 2],
                    },
                    {
                        name: 'Year 1900',
                        data: [133, 156, 947, 408, 6],
                    },
                    {
                        name: 'Year 2000',
                        data: [814, 841, 3714, 727, 31],
                    },
                    {
                        name: 'Year 2016',
                        data: [1216, 1001, 4436, 738, 40],
                    },
                ],
                chart: {
                    renderTo: 'container',
                    type: 'bar',
                },
                title: {
                    text: 'Historic World Population by Region',
                },
                subtitle: {
                    text:
                        'Source: <a href="https://en.wikipedia.org/wiki/World_population">Wikipedia.org</a>',
                },
                xAxis: {
                    categories: [
                        'Africa',
                        'America',
                        'Asia',
                        'Europe',
                        'Oceania',
                    ],
                    title: {
                        text: null,
                    },
                },
                yAxis: {
                    min: 0,
                    title: {
                        text: 'Population (millions)',
                        align: 'high',
                    },
                    labels: {
                        overflow: 'justify',
                    },
                },
                tooltip: {
                    valueSuffix: ' millions',
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
