import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vuex from 'vuex'
import store from './store/index.js'

//移动端适配方案
import '@/assets/js/rem.js'
// 样式重置
import '@/assets/css/common.css'


import { Tabbar,Button,Tab, Tabs, TabbarItem, NavBar,Image,
  Swipe, SwipeItem, Cell, CellGroup,Field,Lazyload ,Grid, 
  GridItem,Sidebar, SidebarItem,Col,Row,Uploader ,Rate,
  DropdownMenu, DropdownItem,Divider ,Picker,Popup,Search,
  Card,SubmitBar,Tag,Checkbox, CheckboxGroup,NoticeBar,List,
  AddressEdit,Toast,Icon,GoodsAction, GoodsActionIcon, GoodsActionButton } from 'vant';

Vue.use(Tabbar).use(TabbarItem).use(NavBar).use(Image)
.use(Cell).use(CellGroup).use(Tab).use(Tabs).use(Field)
.use(Button).use(Swipe).use(SwipeItem).use(Lazyload)
.use(Grid).use(GridItem).use(Sidebar).use(SidebarItem)
.use(Col).use(Row).use(Uploader).use(Uploader ).use(Rate)
.use(DropdownMenu).use(DropdownItem).use(Divider).use(Picker)
.use(Popup).use(Search).use(Card).use(SubmitBar).use(Tag)
.use(Checkbox).use(CheckboxGroup).use(NoticeBar).use(List)
.use(AddressEdit).use(Toast).use(Icon).use(GoodsAction)
.use(GoodsActionIcon).use(GoodsActionButton);

Vue.use(Vuex)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
