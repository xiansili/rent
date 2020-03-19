<template>
  <div id="wrapper">
    <van-tabs v-model="active" background="#f5f6f7">
      <van-tab title="注册" id="regist">
        <van-cell-group class="regist-cell">
          <van-field
            v-model="registStuNumber"
            size="large"
            type="digit"
            placeholder="请输入学号"
            label="学号"
          />
          <van-field
            v-model="registUsername"
            size="large"
            placeholder="请输入昵称"
            label="昵称"
          />
          <van-field
            v-model="registPassword"
            size="large"
            placeholder="请输入密码"
            label="密码"
          />
        </van-cell-group>
        <van-button
          type="primary"
          color="#00adb5"
          class="regist-button"
          size="large"
          @click="registUser"
          >立即注册</van-button
        >
      </van-tab>
      <van-tab title="登录">
        <van-cell-group class="regist-cell">
          <van-field
            v-model="loginStuNumber"
            size="large"
            type="digit"
            placeholder="请输入学号"
            label="学号"
          />
          <van-field
            v-model="loginPassword"
            size="large"
            placeholder="请输入密码"
            label="密码"
          />
        </van-cell-group>
        <van-button
          type="primary"
          color="#00adb5"
          class="regist-button"
          size="large"
          @click="userLogin"
          >立即登录</van-button
        >
      </van-tab>
    </van-tabs>
  </div>
</template>

<script>
import {mapActions  } from "vuex";
import axios from "axios";
import URL from "@/service.config.js";
export default {
  data() {
    return {
      active: 1,
      registStuNumber: "",
      registUsername: "",
      registPassword: "",
      loginStuNumber: "",
      loginPassword: "",
    };
  },
  methods: {
    
    ...mapActions(['savaAdminId','savaUserName','savaLoginState','savaStuNumber']),

    registUser() {
      axios({
        method: "post",
        url: URL.registUser,
        data: {
          userName: this.registUsername,
          passWord: this.registPassword,
          stuNumber: this.registStuNumber
        }
      }).then(res => {
        console.log(res)
        this.$toast.success(res.data.message);
        this.active = 1;
        this.registStuNumber ='';
        this.registUsername ='';
        this.registPassword ='';

      });
    },
    userLogin() {
      axios({
        method: "post",
        url: URL.loginUser,
        data: {
          passWord: this.loginPassword,
          stuNumber: this.loginStuNumber
        }
      }).then(res => {
        if (res.data.status == 200) {
          console.log(res)
          const toast = this.$toast.loading({
            duration: 0, // 持续展示 toast
            forbidClick: true,
            message: "登录成功,即将跳转到主页"
          });
          let second = 3;
          const timer = setInterval(() => {
            second--;
            if (second) {
              toast.message = `倒计时 ${second} 秒`;
            } else {
              clearInterval(timer);
              // 手动清除 Toast
              this.$toast.clear();
              this.$router.push("/");
            }
          }, 800);
         this.savaLoginState(1);
         this.savaUserName(res.data.data.userName);
         this.savaAdminId(res.data.data.adminId);
         this.savaStuNumber(res.data.data.stuNumber);
        }
        else{
           this.$toast.fail(res.data.message);
        }
      });
    }
  },

}
</script>

<style lang="scss" scoped>
#wrapper {
  background: #f5f6f7;
  width: 100%;
  position: absolute;
  top: 0.5rem;
  bottom: 0px;
  left: 0px;
  & .regist-cell {
    margin-top: 0.5rem;
  }
  & .regist-button {
    margin-top: 0.4rem;
  }
}
</style>
