<template>
  <div class="wrapper">
    <div class="swipe">
       <van-swipe
          class="swipe-item"
          :autoplay="3000"
          indicator-color="#c20c0c"
          :height="200"
        >
          <van-swipe-item v-for="(image, index) in imageList" :key="index">
            <img v-lazy="image" />
          </van-swipe-item>
        </van-swipe>
    </div>
    <div class="center">
      <van-row>
        <van-col span="8" class="title">
          <ul class="center-ul">
            <li><van-icon name="user-circle-o" /><span>发布人:</span></li>
            <li><van-icon name="chat-o" /><span>名称:</span></li>
            <li><van-icon name="gold-coin-o" /><span>价格:</span></li>
            <li><van-icon name="wap-home-o" /><span>地址:</span></li>
            <li><van-icon name="comment-o" /><span>描述:</span></li>
            <li><van-icon name="phone-o" /><span>联系电话:</span></li>
            <li><van-icon name="chat-o" /><span>发布时间:</span></li>
          </ul>
        </van-col>
        <van-col span="16" class="message"
          ><ul class="center-ul">
            <li>
              <span>{{ detail.productName }}</span>
            </li>
            <li>
              <span>{{ detail.productName }}</span>
            </li>
            <li>
              <span>{{ detail.productPrice }}</span>
            </li>
            <li>
              <span>{{ detail.productName }}</span>
            </li>
            <li>
              <span>{{ detail.productDescribe }}</span>
            </li>
            <li>
              <span>{{ detail.productName }}</span>
            </li>
            <li>
              <span>{{ detail.createTime }}</span>
            </li>
          </ul></van-col
        >
      </van-row>
    </div>
    <div>
      <van-goods-action class="fotter">
        <van-goods-action-icon icon="chat-o" text="客服" color="#07c160" />
        <van-goods-action-icon icon="cart-o" text="购物车" />
        <van-goods-action-icon icon="star" text="已收藏" color="#ff5000" />
        <van-goods-action-button
          type="warning"
          text="加入清单"
          color="#393e46"
        />
        <van-goods-action-button
          type="danger"
          text="立即租用"
          color="#00adb5"
        />
      </van-goods-action>
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
      current: 0,
      imageList: [],
      detail: {}
    };
  },
  computed: {
    // ...mapGetters(["getProductList"]),
    ...mapState({
      ProductList: state => state.productList
    })
  },
  created() {
    const productId = this.$route.params.productId;
    this.getProduct(productId);
  },
  methods: {
    onChange(index) {
      this.current = index;
      //   console.log(this.ProductList)
    },
    getProduct(productId) {
      let url = URL.getDetail + "?productId=" + productId;
      axios({
        method: "get",
        url: url
      }).then(res => {
        this.detail = res.data.data;

        this.imageList = this.detail.image.split(",");
        console.log(this.imageList);
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.wrapper {
  background: #f7f8fa;
  width: 100%;
  position: absolute;
  top: 0.5rem;
  bottom: 0.5rem;
  left: 0px;
  & .swipe {
      width: 90%;
      margin: 0.2rem auto;
      &-item {
        border-radius: 0.15rem;
        background: #fff;
        height: 1.6rem;
        box-shadow: 0 0.1rem 0.05rem #888888;
        & .van-swipe-item {
          display: flex;
          justify-content: center;
          align-items: center;
          & img {
            width: 1.6rem;
            margin-top: -0.5rem;
          }
        }
      }
    }
  & .center {
    width: 90%;
    margin: 0.5rem auto;
    box-shadow: 0 0.1rem 0.05rem #888888;
    & .title {
    }
    & .message {
    }
    & ul {
      background: #fff;
      height: 3rem;
      display: flex; 
      flex-direction: column ;
      & li {
       flex:1;
      }
    }
  }
  & .fotter {
    z-index: 999;
  }
}
</style>
