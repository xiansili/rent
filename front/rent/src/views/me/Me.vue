<template>
  <div id="me">
    <div id="msg">
      <div class="header-left">
        <van-image
          class="img"
          round
          width="1rem"
          height="1rem"
          src="https://img.yzcdn.cn/vant/cat.jpeg"
        />
      </div>
      <div class="header-right">
        <span>姓名</span>
        <span>联系方式</span>
      </div>
    </div>
    <div id="cell">
      <van-cell-group>
        <van-cell title="登录/注册" value="点我登录" icon="vip-card" is-link to="login" />
        <van-cell title="我的发布" value="去看看"  icon="shop" is-link size="large"/>
        <van-cell title="我的收藏" value="去看看" icon="like" is-link size="large" label="描述信息" />
        <van-cell title="个人信息管理" value="点我编辑" icon="setting" is-link size="large" label="描述信息" to="userinfo" />
      </van-cell-group>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style lang="scss" scoped>
#me {
  // background: #f8f8f8;
  background: #f7f8fa;
  width: 100%;
  position: absolute;
  top: 0.5rem;
  bottom: 0.6px;
  left: 0px;

  & #msg {
    display: flex;
    flex-direction: row;
    height: 1.3rem;
    & .header-left {
      flex: 1;
      display: flex;
      background: #000;
      & .img {
        margin: auto;
      }
    }
    & .header-right {
      flex: 2;
      margin: auto;
      & span {
        height: 0.5rem;
        display: block;
        margin-left: 0.1rem;
      }
    }
  }
  & #cell{
      margin-top: 0.5rem;
  }
}
</style>
