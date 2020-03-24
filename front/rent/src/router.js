import Vue from "vue";
import Router from "vue-router";
import Index from "./views/index/Index.vue";
import Category from "./views/category/Category.vue";
import Product from "./views/category/Product.vue";
import Detail from "./views/category/Detail.vue";
import Me from "./views/me/Me.vue";
import Cart from "./views/cart/Cart.vue";
import Login from "./views/me/Login.vue";
import Publish from "./views/index/publish.vue";
import Userinfo from "./views/me/Userinfo.vue";
import FooterBar from "./components/FooterBar.vue";

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: "/",
      name: "index",
      components: {
        default: Index,
        "footer-bar": FooterBar
      }
      // meta:{
      //   keepAlive: true
      // }
    },
    {
      path: "/category",
      name: "category",
      components: {
        default: Category,
        "footer-bar": FooterBar
      }
    },
    {
      path: "/product/:typeName",
      name: "product",
      components: {
        default: Product
        // 'footer-bar': FooterBar
      }
    },
    {
      path: "/cart",
      name: "cart",
      components: {
        default: Cart,
        "footer-bar": FooterBar
      }
    },
    {
      path: "/me",
      name: "me",
      component: Me,
      components: {
        default: Me,
        "footer-bar": FooterBar
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login
    },
    {
      path: "/publish",
      name: "publish",
      component: Publish
    },
    {
      path: "/userinfo",
      name: "userinfo",
      component: Userinfo
    },
    {
      path: "/detail/:productId",
      name: "detail",
      component: Detail
    }
    //   path: '*',
    //   component: Error
  ]
});
