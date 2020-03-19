<template>
  <div id="app">
    <HeaderBar/>
    <router-view v-if="isRouterAlive" />
    <FooterBar/>
  </div>
</template>

<script>
import {mapActions} from 'vuex';
import axios from "axios";
import URL from "@/service.config.js";
import FooterBar from "@/components/FooterBar";
import HeaderBar from "@/components/HeaderBar";
export default {
  components: {
    FooterBar,
    HeaderBar
  },
  provide(){
    return{
      reload:this.reload
    }
  },
  data() {
    return {
      isRouterAlive:true
    };
  },
  created() {
     axios({
      method: "get",
      url: URL.getTypes
    }).then(res => {
      this.savaTypeList(res.data.data)
    });
  },
  methods: {
    ...mapActions(["savaTypeList"]),

    reload(){
      this.isRouterAlive = false;
      this.$nextTick(function(){
        this.isRouterAlive = true;
      })
    }
  },
};
</script>

<style lang="scss" scoped>
</style>
