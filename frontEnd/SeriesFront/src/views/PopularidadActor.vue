<template>
  <el-container>
    <el-header>
      <h1>Popularidad Actor</h1>
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
            <h3>Gráfico</h3>
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
                        data: [1, 2, 3], // sample data
                    },
                ],
                chart: {
                    renderTo: 'container',
                    type: 'column',
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
