<template>
  <div id="wrapper">
    <div class="header">
      <van-dropdown-menu class="header-dropdown">
        <van-dropdown-item
          class="header-dropdown-item"
          v-model="value1"
          :options="option1"
        />
        <van-dropdown-item
          class="header-dropdown-item"
          v-model="value2"
          :options="option2"
        />
      </van-dropdown-menu>
    </div>
    <div class="product">
      <van-list
        class="product-list"
        v-model="loading"
        :finished="finished"
        finished-text="没有更多了"
        @load="onLoad"
      >
        <van-card
          class="product-list-card"
          v-for="(item, index) in productList"
          :key="index"
          :price="item.productPrice"
          :desc="item.productDescribe"
          :title="item.productName"
          :thumb="item.image"
          @click="toDetail(item.productId)"
        >
          <div slot="tags">
            <van-tag size="medium" color="#00adb5" mark type="danger">{{item.productBrand}}</van-tag>
            <van-tag size="medium" color="#00adb5" mark type="danger">{{item.productType}}</van-tag>
          </div>
          <div slot="footer">
            <span class="footer">{{ item.createTime }}</span>
          </div>
        </van-card>
      </van-list>
    </div>
  </div>
</template>

<script>
import { mapActions } from "vuex";
import axios from "axios";
import URL from "@/service.config.js";
export default {
  data() {
    return {
      value1: 0,
      value2: "a",
      list: [],
      loading: false,
      finished: false,
      option1: [
        { text: "全部商品", value: 0 },
        { text: "新款商品", value: 1 },
        { text: "活动商品", value: 2 }
      ],
      option2: [
        { text: "默认排序", value: "a" },
        { text: "好评排序", value: "b" },
        { text: "销量排序", value: "c" }
      ],
      //商品列表
      productList: []
    };
  },

  created() {
    const typeName = this.$route.params.typeName;
    this.getProduct(typeName);
  },
  methods: {
    ...mapActions(["savaProductList"]),
    onLoad() {
      // 异步更新数据
      // setTimeout 仅做示例，真实场景中一般为 ajax 请求
      setTimeout(() => {
        for (let i = 0; i < 10; i++) {
          this.list.push(this.list.length + 1);
        }
        // 加载状态结束
        this.loading = false;
        // 数据全部加载完成
        if (this.list.length >= 40) {
          this.finished = true;
        }
      }, 1000);
    },
    toDetail(productId) {
      this.$router.push( `/detail/${productId}`);
    },
    // 获取商品列表
    getProduct(typeName) {
      let url = URL.getProductsByType + "?productType=" + typeName;
      axios({
        method: "get",
        url: url,
      }).then(res => {
        this.savaProductList(res.data.data);
        let product = res.data.data;
        product.forEach(element => {
          this.productList.push(element);
          // 解析
          element.image = element.image.split(",")[0];
          // 解析时间为标准格式
          let newTime = this.publishTime(element.createTime);
          element.createTime = newTime;
          element.productPrice =  element.productPrice + "/天";
        });
      });
    },
    // 发布时间处理
    publishTime(time) {
      time = time.replace(/-/g, ":").replace(" ", ":");
      time = time.split(":");
      let newTime = new Date(
        time[0],
        time[1] - 1,
        time[2],
        time[3],
        time[4],
        time[5]
      );
      let year = newTime.getFullYear();
      let month = newTime.getMonth();
      let date = newTime.getDate();
      let hours = newTime.getHours();
      let minutes = newTime.getMinutes();
     
      let nowTime = new Date();
      let nowyear = nowTime.getFullYear();
      let nowmonth = nowTime.getMonth();
      let nowdate = nowTime.getDate();
      let nowhours = nowTime.getHours();
      let nowminutes = nowTime.getMinutes();

// 判断发布时间
      if (nowyear - year > 0) {
        return nowyear - year + "年前";
      } else {
        if (nowmonth - month > 0) {
          return nowmonth - month + "个月前";
        } else if (nowmonth - month == 0) {
          if (nowdate - date > 0) {
            return nowdate - date + "天前";
          } else if (nowdate - date == 0) {
            if (nowhours - hours > 0) {
              return nowhours - hours + "小时前";
            } else if (nowhours - hours == 0) {
              if (nowminutes - minutes > 0) {
                return nowminutes - minutes + "分钟前";
              }else if(nowminutes - minutes==0){
                return "刚刚";
                }
            }
          }
        }
      }
    }
  }
};
</script>

<style lang="scss" scoped>
#wrapper {
  background: #f7f8fa;
  left: 0px;
  & .header {
    width: 90%;
    margin: 0.5rem auto 0.1rem;
    &-dropdown {
      z-index: 100;
      &-item {
        z-index: 100;
      }
    }
  }
  & .product {
    width: 90%;
    margin: 0 auto;
    &-list {
      &-card {
        background-color: #fff;
        border-radius: 0.1rem;
        line-height: 100%;
        // & img{
          
        // }
        & .footer{
          position: absolute;
          bottom: 0.15rem;
          right: 0.15rem;
          font-size: 0.15rem;
        }
      }
    }
  }
}
</style>
