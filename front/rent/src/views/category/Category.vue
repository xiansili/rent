<template>
  <div class="wrapper" :key="menuKey">
    <van-notice-bar
      class="notice"
      color="#222831"
      mode="closeable"
      background="#00adb5"
      left-icon="volume-o"
    >
      2020年3月20号晚上8点限时活动等你来哦！！！
    </van-notice-bar>
    <div class="left">
      <van-sidebar v-model="activeKey" @change="onChange">
        <van-sidebar-item
          @click="change(index)"
          :class="{ white: isbgc, bgc: idx === index }"
          :title="item.className"
          v-for="(item, index) in typeList"
          :key="index"
        />
      </van-sidebar>
    </div>
    <div class="right" v-if="isshow">
      <h1 class="right-title">{{ massage }}</h1>
      <van-divider />
      <van-grid :column-num="2" icon-size="80px">
        <van-grid-item
          v-for="(item, index) in allTypesList"
          :key="index"
          :icon="item.type_image"
          :text="item.type_name"
          @click="toProduct(item.type_name)"
        />
      </van-grid>
    </div>
  </div>
</template>

<script>
import { mapGetters, mapState } from "vuex";
import axios from "axios";
import URL from "@/service.config.js";
export default {
  inject: ["reload"],
  data() {
    return {
      massage: "电子产品",
      activeKey: 0,
      isshow: true,
      isbgc: true,
      idx: "0",
      whiteclass: "white",
      bgcclass: "bgc",
      allTypesList: [],
      menuKey: 1
    };
  },
  watch: {},
  computed: {
    // ...mapGetters(["getTypeList"]),
    ...mapState({
      typeList: state => state.typeList
    })
  },
  methods: {
    toProduct(typeName) {
      this.$router.push(`/Product/${typeName}`);
    },
    change(index) {
      this.activeKey = index;
    },
    onChange(index) {
      this.idx = index;
      this.massage = this.typeList[index].className;
      this.findTypeByName(this.typeList[index].className);
      this.allTypesList = [];
    },
    findTypeByName(className) {
      let url = URL.getAllTypes + "?categoryName=" + className;
      axios({
        method: "get",
        url: url
      }).then(res => {
        for (let index = 0; index < res.data.data.length; index++) {
          res.data.data[index].type_image =
            "http://localhost:9090/" + res.data.data[index].type_image;
          this.allTypesList.push(res.data.data[index]);
        }
      });
    }
  },
  created() {
    this.change(2);
  }
};
</script>

<style lang="scss" scoped>
.wrapper {
  background: #eeeeee;
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  width: 100%;
  height: 100%;
  & .notice {
    position: fixed;
    width: 100%;
    top: 0.5rem;
    z-index: 99;
  }
  & .left {
    float: left;
    position: fixed;
    top: 1rem;
    & .white {
      background: #fff;
    }
    & .bgc {
      background: #00adb5;
      color: #fff;
      border-bottom-right-radius: 0.2rem;
      border-top-right-radius: 0.2rem;
    }
  }
  & .right {
    background: #fff;
    margin-top: 1rem;
    margin-left: 1.2rem;
    margin-right: 0.2rem;
    height: 100%;
    border-radius: 0.1rem;
    overflow: hidden;
    &-title {
      text-align: center;
    }
  }
}
</style>
