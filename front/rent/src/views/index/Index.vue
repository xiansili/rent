<template>
  <div id="wrapper">
    <div class="header" ref="element">
      <div class="search">
        <van-search
          v-model="search"
          shape="round"
          background="#00adb5"
          placeholder="请输入搜索关键词"
        />
      </div>
      <div class="swipe">
        <van-swipe
          class="swipe-item"
          :autoplay="3000"
          indicator-color="#c20c0c"
          :height="200"
        >
          <van-swipe-item v-for="(image, index) in images" :key="index">
            <img v-lazy="image" />
          </van-swipe-item>
        </van-swipe>
      </div>
    </div>

    <!-- 分类导航 -->
    <div class="gird" ref="gird">
      <van-grid square>
        <van-grid-item
          v-for="(item, index) in navList"
          :key="index"
          :icon="item.imgUrl"
          :text="item.text"
        />
      </van-grid>
    </div>
    <!-- 推荐模块 -->
    <div class="recommend">
      <van-grid :gutter="1" :column-num="2">
        <van-grid-item
          v-for="value in 8"
          :key="value"
          icon="photo-o"
          text="文字"
        />
      </van-grid>
    </div>
  </div>
</template>

<script>
import Hot from "@/assets/image/indePage/hot.png";
import Time from "@/assets/image/indePage/time.png";
import Star from "@/assets/image/indePage/star.png";
import Phone from "@/assets/image/indePage/phone.png";
import Computer from "@/assets/image/indePage/computer.png";
import Book from "@/assets/image/indePage/book.png";
import Like from "@/assets/image/indePage/like.png";
import Clothes from "@/assets/image/indePage/clothes.png";
export default {
  data() {
    return {
      imgUrl: Hot,
      search: "",
      //轮播图
      images: [
        "https://img10.360buyimg.com/mobilecms/s500x500_jfs/t1/97513/20/11589/185718/5e39426fE51cbc0f1/4c2f4a9088190d51.jpg",
        "https://img12.360buyimg.com/mobilecms/s280x280_jfs/t1/105129/23/11393/59351/5e33b834E3f6241f8/a5088a0df407f83e.png.webp",
        "https://img12.360buyimg.com/mobilecms/s280x280_jfs/t1/88636/37/2294/198759/5dcd1ed0Ea2c619d9/5c58d1ee342e7bb4.jpg.webp",
        "https://img30.360buyimg.com/jdcms/s300x300_jfs/t1/94811/28/10868/162515/5e217cdfEc4e4ea0c/79eb48fd7b727bce.jpg.webp"
      ],
      navList: [
        {
          imgUrl: Time,
          text: "限时活动",
          url: ""
        },
        {
          imgUrl: Hot,
          text: "热门产品",
          url: ""
        },
        {
          imgUrl: Star,
          text: "闲置好物",
          url: ""
        },
        {
          imgUrl: Computer,
          text: "硬核电脑",
          url: ""
        },
        {
          imgUrl: Phone,
          text: "移动设备",
          url: ""
        },
        {
          imgUrl: Book,
          text: "闲置好书",
          url: ""
        },
        {
          imgUrl: Clothes,
          text: "衣物",
          url: ""
        },
        {
          imgUrl: Like,
          text: "优惠券",
          url: ""
        }
      ]
    };
  },
  methods: {
    swipe() {
      // let height = this.$refs.element.offsetHeight;
      // this.$refs.gird.style.marginTop = height + 100 + "px";
    }
  },
  created() {},
  mounted() {
    this.swipe();
  }
};
</script>

<style lang="scss" scoped>
#wrapper {
  width: 90%;
  margin: 0.5rem auto;
  & .header {
    position: absolute;
    background: #00adb5;
    width: 100%;
    height: 1.5rem;
    top: 0.5rem;
    // bottom: 1rem;
    left: 0rem;
    border-radius: 0 0 0.2rem 0.2rem;
    & .search {
      position: fixed;
      width: 100%;
      z-index: 99;
    }
    & .swipe {
      width: 90%;
      margin: 0 auto;
      margin-top: 0.6rem;
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
  }
  & .gird {
    margin-top: 3rem;
    box-shadow: 0 0.1rem 0.05rem #888888;
  }

  & .recommend{
    margin-top: 0.2rem;
    box-shadow: 0 0.1rem 0.05rem #888888;
  }
}
.clearfix:after {
  content: "."; /*加一段内容*/
  display: block; /*让生成的元素以块级元素显示，占满剩余空间*/
  height: 0; /*避免生成的内容破坏原有布局高度*/
  clear: both; /*清除浮动*/
  visibility: hidden; /*让生成的内容不可见*/
}
</style>
