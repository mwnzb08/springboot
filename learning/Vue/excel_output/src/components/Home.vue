<template>
  <div>
    <h2>您好，欢迎来到excel_output</h2>
    <div>
      <div>
        <div class="conf1">
          <ul>
            <h4>操作一</h4>
            <li class="liStyle">
              <textarea
                class="textarea_common"
                style="float: left"
                rows="5"
                v-model="text1"
              ></textarea>
              <textarea
                class="textarea_common"
                rows="5"
                readonly
                v-model="text1_lower"
              ></textarea>
              <span><button>push</button></span>
            </li>
            <li class="liStyle">
              <h4>操作二</h4>
              <textarea
                class="textarea_common"
                style="float: left"
                rows="5"
                v-model="text2"
              ></textarea>
              <textarea
                class="textarea_common"
                rows="5"
                readonly
                v-model="text1_lower2"
              ></textarea>
            </li>
            <li class="liStyle">
              <h4>操作三</h4>
              <textarea
                class="textarea_common"
                style="float: left"
                rows="5"
                v-model="text2"
              ></textarea>
              <textarea
                class="textarea_common"
                rows="5"
                readonly
                v-model="text1_lower2"
              ></textarea>
            </li>
          </ul>
        </div>
        <div style="float: right;width: 40%">
          <input
            type="file"
            ref="upload"
            accept=".xls,.xlsx"
            class="outputlist_upload"
          />
          <gc-spread-sheets :hostClass="hostClass">
            <gc-worksheet
              :dataSource="dataTable"
              :autoGenerateColumns="autoGenerateColumns"
            >
              <template v-for="i in list">
                <gc-column
                  v-bind:key="i"
                  :width="width"
                  :dataField="i.head"
                  :visible="visible"
                  :formatter="formatter"
                  :resizable="resizable"
                ></gc-column>
              </template>
            </gc-worksheet>
          </gc-spread-sheets>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import "@grapecity/spread-sheets/styles/gc.spread.sheets.css";
import "@grapecity/spread-sheets-vue";
import XLSX from "xlsx";
export default {
  data() {
    return {
      text1: "  $F{HELLO.WORld}$dfSF{kSSSSFFFFFFFFFFFFFFFFFFAS.dada  }v   ",
      text2: '  @uy.Sdad varchar(20) =null,\n  @uip date  = null }"',
      text1_lower: "",
      text1_lower2: "",
      hostClass: "spread-host",
      autoGenerateColumns: true,
      width: 205,
      visible: true,
      resizable: true,
      formatter: " #0.00",
      head: null,
      list: [{ head: "A" }, { head: "B" }, { head: "C" }],
      dataTable: []
    };
  },
  mounted() {
    this.dataTables();
    this.$refs.upload.addEventListener("change", e => {
      this.excelData(e);
    });
    this.text1_change();
    this.text1_change2();
  },
  watch: {
    text1: function(newValue, oldValue) {
      if (newValue != null && oldValue != null) {
        this.text1_change();
      }
    },
    text2: function(newValue, oldValue) {
      if (newValue != null && oldValue != null) {
        this.text1_change2();
      }
    }
  },
  computed: {},
  methods: {
    dataTables() {
      for (let i = 1; i <= 30; i++) {
        this.dataTable.push({ A: "not data", B: "blank", C: "无数据" });
      }
      return this.dataTable;
    },
    excelData(e) {
      const files = e.target.files;
      console.log("file :========" + files[0].name);
      if (files.length <= 0) {
        //如果没有文件名
        return false;
      } else if (!/\.(xls|xlsx)$/.test(files[0].name.toLowerCase())) {
        console.log("上传格式不正确，请上传xls或者xlsx格式");
        return false;
      }
      const fileReader = new FileReader();
      fileReader.onload = ev => {
        try {
          const data = ev.target.result;
          const workbook = XLSX.read(data, {
            type: "binary"
          });
          console.log(workbook)
          this.dataTable = [];
          this.dataTable.push(XLSX.utils.sheet_to_json(workbook.Sheets[workbook.SheetNames[0]]))
          this.$refs.upload.value = "";
        } catch (e) {
          console.log("error");
          return false;
        }
      };
      fileReader.readAsBinaryString(files[0]);
    },
    text1_change() {
      let arr = [];
      this.text1
        .trim()
        .split("}")
        .forEach(it => {
          let result = it.trim() + "}";
          if (result.startsWith("$") && result.endsWith("}")) {
            let word11 = result.substring(0, 1);
            let word12 = result.substring(
              result.indexOf("{"),
              result.indexOf("{") + 1
            );
            let word13 = result.substring(result.indexOf("{") + 1).trim();
            let words = (word11 + word12 + "v." + word13).toLowerCase();
            arr.push(words);
          }
        });
      this.text1_lower = arr;
    },
    text1_change2: function() {
      let result = [];
      this.text2.split(",").forEach(it => {
        let data = it.trim().substring(0, it.trim().indexOf(" ")) + "}";
        let data2 = data.replace("@", "${");
        result.push(data2);
      });
      this.text1_lower2 = result;
    }
  }
};
</script>
<style>
.conf1 {
  float: left;
  width: 60%;
}

.textarea_common {
  width: 45%;
  resize: none;
}

.liStyle {
  list-style: none;
}

.spread-host {
  width: 90%;
  height: 70vh;
}
</style>
