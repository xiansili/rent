<template>
  <div id="footer">
    <van-tabbar
      class="footerbar"
      v-model="active"
      inactive-color="#777777"
      active-color="#000000"
    >
      <van-tabbar-item
        v-for="(item, index) in tabbars"
        :key="index"
        :to="item.name"
        @click="changeActive(index)"
      >
        <span>{{ item.title }}</span>
        <img
          slot="icon"
          slot-scope="props"
          :src="props.active ? item.active : item.inactive"
          class="icon"
        />
      </van-tabbar-item>
    </van-tabbar>
  </div>
</template>

<script>
import index0 from "@/assets/image/index0.png";
import index1 from "@/assets/image/index1.png";
import kind0 from "@/assets/image/kind0.png";
import kind1 from "@/assets/image/kind1.png";
import cart0 from "@/assets/image/cart0.png";
import cart1 from "@/assets/image/cart1.png";
import me0 from "@/assets/image/me0.png";
import me1 from "@/assets/image/me1.png";
export default {
  data() {
    return {
      active: 0,
      tabbars: [
        {
          name: "/",
          title: "发现",
          active: index1,
          inactive: index0
        },
        {
          name: "Category",
          title: "分类",
          active: kind1,
          inactive: kind0
        },
        {
          name: "cart",
          title: "清单",
          active: cart1,
          inactive: cart0
        },
        {
          name: "me",
          title: "我的",
          active: me1,
          inactive: me0
        }
      ]
    };
  },
  methods: {
    changeActive(index) {
      this.active = index;
    }
  },
  //通过路由跳转判断选中的样式
  created() {
    if (this.$route.name == "index") {
      this.active = 0;
    } else if (this.$route.name == "category") {
      this.active = 1;
    } else if (this.$route.name == "cart") {
      this.active = 2;
    } else if (this.$route.name == "me") {
      this.active = 3;
    }
  }
};
</script>

<style lang="scss" scoped>
#footer {
  // position: fixed;
  // bottom: 0;
  // left: 0;
  // right: 0; 
  z-index: 999;
  & .footerbar {
    background: #eeeeee;
    border-top: 0.01rem solid #000;
  }
  & .icon {
    width: 0.3rem;
    height: 0.3rem;
  }
}
</style>
