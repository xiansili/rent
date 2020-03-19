<template>
  <div id="header">
    <div class="nav">
      <div class="nav-left" @click="publish">发布</div>
      <div class="nav-center" @click="index">校园共享</div>
      <div class="nav-right" @click="login">{{userName}}</div>
    </div>
  </div>
</template>

<script>
// 获取数据
import { mapState,mapGetters} from 'vuex';
export default {
  data() {
    return {
      loginState:'',
    }
  },
  created() {
    // this.$store.commit("SET_USERNAME",this.loginState)
  },
  computed: {
    ...mapGetters(["getUserName"]),
    userName(){
      return this.$store.state.userName
    },
    // ...mapState(['loginState']),
  },
  watch: {
    // loginState(){
    //   // this.loginState = 
    // }
  },
  methods: {
    publish(){
      this.$router.push("/publish");
    },
    login(){
      this.$router.push("/login");
    },
    index(){
      this.$router.push("/");
    }
  },
};
</script>

<style lang="scss" scoped>
#header {
    position:fixed;
    top: 0;
    left: 0;
    right: 0;
    z-index: 999;
  & .nav {
    position: absolute;
    display: flex;
    flex-direction: row;
    align-items: center;
    width: 100%;
    background: #00adb5;
    height: 0.5rem;
    color: #fff;
    & .nav-left {
      flex: 1;
      text-align: center;
    }
    & .nav-center {
      flex: 2;
      text-align: center;
    }
    & .nav-right {
      flex: 1;
      text-align: center;
    }
  }
}
</style>
