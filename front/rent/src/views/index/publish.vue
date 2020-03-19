<template>
  <div class="publish">
    <div class="publish-from">
      <h1 class="publish-from-title">发布商品信息</h1>
      <van-field
        v-model="commodityName"
        class="publish-from-class"
        label="商品名称"
        size="large"
      />
      <van-field
        readonly
        clickable
        label="类型"
        :value="commodityType"
        placeholder="选择类型"
        @click="showPicker = true"
      />
      <van-popup v-model="showPicker" position="bottom">
        <van-picker
          show-toolbar
          :columns="types"
          @cancel="showPicker = false"
          @confirm="onConfirm"
        />
      </van-popup>
      <van-field v-model="commodityBrand" label="品牌" size="large" />
      <van-field
        v-model="rentalPrice"
        type="number"
        label="租金/天"
        size="large"
      />
      <van-field v-model="address" label="地址" size="large" />
      <van-field
        v-model="describe"
        rows="2"
        autosize
        label="描述"
        type="textarea"
        maxlength="80"
        placeholder="商品描述，内容不超过80字"
        show-word-limit
      />
      <h1>商品图片(最多上传3张图片)</h1>
      <van-uploader
        v-model="photoList"
        :max-count="3"
        :after-read="afterRead"
        multiple
      />
      <van-button
        icon="upgrade"
        type="primary"
        round
        size="large"
        class="publish-from-button"
        color="#c20c0c"
        block
        @click="publish"
        >点击发布</van-button
      >
    </div>
  </div>
</template>

<script>
import {mapGetters} from 'vuex';
import axios from "axios";
import URL from "@/service.config.js";
export default {
  data() {
    return {
      commodityName: "",
      describe: "",
      commodityBrand: "",
      rentalPrice: "",
      address: "",
      commodityType: "",
      //选择器
      showPicker: false,
      types:[],
      photoList: [],
      imageFile: []
    };
  },
  created() { 
    for (let index = 0; index < this.getTypeList.length; index++) {
      this.types.push(this.getTypeList[index].className);
    }
  },
  computed: {
     ...mapGetters(["getAdminId",'getloginState',"getTypeList"])
    
  },
  methods: {
    onConfirm(value) {
      this.commodityType = value;
      this.showPicker = false;
    },
    // 文件上传完毕后会触发after-read回调函数
    afterRead(file) {
      this.imageFile.push(file.file); // imageFile是一个数组
    },
    //发布商品信息
    publish() {
      if (this.imageFile.length==0) {
        console.log("请选择图片")
      }else{
      let formData = new FormData();
      for (let index = 0; index < this.imageFile.length; index++) {
        formData.append("file", this.imageFile[index]);
      }
      formData.append("productName",this.commodityName);
      formData.append("productBrand", this.commodityBrand);
      formData.append("productDescribe", this.describe);
      formData.append("productPrice", this.rentalPrice);
      formData.append("productType", this.commodityType);
      axios({
        method: "post",
        url: URL.publish,
        data: formData
          // {
          //   productName: this.commodityName,
          //   productBrand: this.commodityBrand,
          //   productDescribe: this.describe,
          //   productPrice: this.rentalPrice,
          //   productType: this.commodityType,
          // }
      })
        .then(res => {
          if (res.data.status = 200) {
             this.$toast.fail("发布成功");
            this.$router.push("/");
          } else {
             this.$toast.fail("发布失败");
          }
        })
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.publish {
  background: #f7f8fa;
  width: 100%;
  position: absolute;
  top: 0.5rem;
  // bottom: 0.6rem;
  // left: 0px;
  &-from {
    width: 90%;
    margin: 0 auto;
    margin-bottom: 0.6rem;

    &-class {
      margin-top: 0.6rem;
    }
    &-title {
      position: fixed;
      background: #fff;
      top: 0.5rem;
      width: 90%;
      height: 0.5rem;
      line-height: 0.5rem;
      z-index: 99;
      text-align: center;
    }
  }
}
</style>
