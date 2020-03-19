<template>
  <div id="wrapper">
    <van-card
      num="2"
      price="2.00"
      desc="描述信息"
      title="商品标题"
      thumb="https://img.yzcdn.cn/vant/ipad.jpeg"
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
    onSubmit() {} ,
    //判断购物车是否为空
    isCartListNull(){
      if (this.cartList.length==0) {
        console.log("购物车为空")
      } else{
        console.log("购物车不为空")
      }
      
    }
  },
  created() {
    this.isCartListNull();
  },
  mounted() {
   
  },
};
</script>

<style lang="scss" scoped>
#wrapper {
  background: #f5f6f7;
  width: 90%;
  height: 5rem;
  margin: 0.5rem auto;
  & .submit {
    & .van-submit-bar {
      position: fixed;
      bottom: 0.6rem;
    }
  }
}
</style>
