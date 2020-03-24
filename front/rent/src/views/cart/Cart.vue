<template>
  <div id="wrapper">
    <van-card
      class="wrapper-list-card"
      v-for="(item, index) in cartList"
      :key="index"
      num="2"
      :price="item.productPrice"
      :desc="item.productDescribe"
      :title="item.productName"
      :thumb="item.image"
    >
      <div slot="tags">
        <van-tag plain type="danger">标签</van-tag>
        <van-tag plain type="danger">标签</van-tag>
      </div>
      <div slot="footer">
        <van-button size="mini">按钮</van-button>
        <van-button size="mini">按钮</van-button>
      </div>
    </van-card>
    <div class="submit">
      <van-submit-bar :price="3050" button-text="提交订单" @submit="onSubmit">
        <van-checkbox v-model="checked">全选</van-checkbox>
        <span slot="tip">
          你的收货地址不支持同校送, <span>修改地址</span>
        </span>
      </van-submit-bar>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import URL from "@/service.config.js";
import { mapGetters, mapState } from "vuex";
export default {
  data() {
    return {
      //全选
      checked: true,
      //购物车表
      cartList: []
    };
  },
  methods: {
    //提交订单事件处理函数
    onSubmit() {},
    //判断购物车是否为空
    isCartListNull() {
      if (this.cartList.length == 0) {
        this.$toast.fail("购物车为空");
      }
    },
    getCart() {
      let url = URL.getCart + '?stuNumber=' + this.getStuNumber;
      axios({
        method: "get",
        url: url
      })
        .then(res => {
          res.data.data.forEach(element => {
            this.cartList.push(element);
            element.image = element.image.split(",")[0];
          });
          this.isCartListNull()
        })
        .catch(err => {});
    }
  },
  computed: {
    ...mapGetters(["getloginState", "getStuNumber"])
  },
  created() {
    this.getCart();
  },
  mounted() {}
};
</script>

<style lang="scss" scoped>
#wrapper {
  width: 90%;
  margin: 0.8rem auto;
  & .submit {
    & .van-submit-bar {
      position: fixed;
      bottom: 0.6rem;
    }
  }
}
</style>
