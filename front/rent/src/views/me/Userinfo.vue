<template>
  <div class="userinfo">
    <div class="userinfo-from">
      <h1 class="userinfo-from-title">编辑个人信息</h1>
      <van-cell-group class="userinfo-from-group">
        <van-field v-model="name" label="真实姓名" size="large" />
        <van-field v-model="telNumber" type="tel" label="手机号" size="large" />
        <van-field v-model="college" label="学院" size="large" />
        <van-field v-model="age" label="年龄" size="large" />
        <van-field v-model="sex" label="性别" size="large" />
        <van-field v-model="address" label="收货地址" size="large" />
      </van-cell-group>
      <van-button
        icon="success"
        type="primary"
        round
        size="large"
        color="#c20c0c"
        class="userinfo-from-button"
        block
        @click="addUserInfo"
        >确认提交</van-button
      >
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";
import URL from "@/service.config.js";
export default {
  data() {
    return {
      name:"",
      telNumber: "",
      age: "",
      sex: "",
      college: "",
      address: ""
    };
  },

//  一般我们的异步请求都写在这里。
//  在这个阶段，数据和DOM都已被渲染出来。
  mounted() {
    if (this.getloginState==1) {
       axios({
      method: "post",
      url: URL.getUserInfo,
      data:{
        adminId:this.getAdminId
        }
    }).then(res=>{
          this.name = res.data.data.userName;
          this.telNumber = res.data.data.phoneNumber;
          this.age = res.data.data.userAge;
          this.sex = res.data.data.userSex;
          this.college = res.data.data.college;
          this.address = res.data.data.address;
    });
    }else{
      this.$toast.fail("请先登录");
    }
  },
  // 计算属性
  computed: {
    ...mapGetters(["getAdminId",'getloginState'])
  },
  methods: {
    addUserInfo() {
      if (this.getloginState==0) {
        this.$toast.fail("请先登录");
      } else {
        axios({
          method: "post",
          url: URL.addUserInfo,
          data: {
            userName: this.name,
            phoneNumber: this.telNumber,
            userAge: this.age,
            userSex: this.sex,
            college: this.college,
            address: this.address,
            adminId: this.getAdminId
          }
        }).then(res => {
          this.name = res.data.data.userName;
          this.telNumber = res.data.data.phoneNumber;
          this.age = res.data.data.userAge;
          this.sex = res.data.data.userSex;
          this.college = res.data.data.college;
          this.address = res.data.data.address;
          this.getAdminId = res.data.data.getAdminId;
        });
      }
    }
  }
};
</script>

<style lang="scss" scoped>
.userinfo {
  background: #f7f8fa;
  width: 100%;
  position: absolute;
  top: 0.5rem;
  &-from {
    width: 90%;
    margin: 0 auto;
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
    &-group {
      margin-top: 0.6rem;
    }
    &-button {
      margin-top: 0.2rem;
    }
  }
}
</style>
