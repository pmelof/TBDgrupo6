  <template>
    <el-row>
      </el-col>
      <el-col :span="12">
        <div class="poster">
          <img v-bind:src="urlImg" id="poster" alt="poster" width="300">
        </div>
      </el-col>
      <el-col :span="12">
        <h2 v-bind:src="nombreSerie">{{nombreSerie}}</h2>
        <el-table
            :data="tableData"
            style="width: 100%">
            <el-table-column
              prop="columna1"
              label=""
              class-name="bold"
              width="200">
            </el-table-column>
            <el-table-column
              prop="columna2"
              label=""
              class="wordWrap"
              width="450">
            </el-table-column>
          </el-table>
          <br>
          <el-button
          type="primary"
          v-on:click="closeModal"
          >Cerrar</el-button>
      </el-col>
    </el-row>
  </template>

  <script>
  import axios from 'axios'
    export default {
      data() {
        return {
          tableData: [],
          urlImg: '',
          nombreSerie: '',
          isOpenChild: true,
        }
      },
      props: {
        nombreSerie: String
      },
      methods: {
        getInfoSerie(nombreSerie) {
            axios.get('http://localhost:8080/series').then(response => {
                var seriesInfoTemp = response.data
                for (var serie of seriesInfoTemp) {
                    if (serie.nombre == nombreSerie) {
                        this.nombreSerie = serie.nombre

                        var fechaInicio = {columna1: 'Fecha de inicio', columna2: serie.fechaInicio}

                        if (serie.fechaFin != 0) {
                          var fechaFin = {columna1: 'Fecha de fin', columna2: serie.fechaFin}
                        } else {
                          var fechaFin = {columna1: 'Fecha de fin', columna2: '---'}
                        }

                        var emisor = {columna1: 'Emisor', columna2: serie.emisor}
                        var sinopsis = {columna1: 'Sinopsis', columna2: serie.sinopsis}

                        this.tableData.push(fechaInicio)
                        this.tableData.push(fechaFin)
                        this.tableData.push(emisor)
                        this.tableData.push(sinopsis)
                        this.urlImg = serie.imagen

                        break
                    }
                }
            })

            axios.get('http://localhost:8080/personajes').then(response => {
                var reparto = ''
                var personajesInfo = response.data
                for (var personaje of personajesInfo) {
                    if (personaje.serie.nombre == nombreSerie) {
                        reparto += personaje.actor.nombre + ' (' + personaje.nombre + '), '
                    }
                }
                var repartoFinal = reparto.substring(0, reparto.length - 2)
                var repartoObject = {columna1: 'Reparto', columna2: repartoFinal}
                this.tableData.push(repartoObject)
            })
        },

        closeModal() {
          this.isOpenChild = false
          this.$emit('isOpenChild', this.isOpenChild)
        }
      },

      created() {
        this.getInfoSerie(this.nombreSerie)
      },
    }
  </script>

<style>
  td.bold {
    font-weight: bold;
  }

  .wordWrap {
    word-wrap: normal;
  }
</style>