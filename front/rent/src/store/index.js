import Vue from 'vue'
import Vuex from 'vuex'
//使用vuex
Vue.use(Vuex);
//创建Vuex实例

const store = new Vuex.Store({
    // 定义状态
    state:{
        // 登录状态
        loginState:0,
        userName:"未登录",
        adminId:"",
        stuNumber:"",
        typeList:[],
        productList:[],
    },

    // 通常通过getters取数据 (this.$store.getters.userName;)
    getters:{
        getUserName:state=>state.userName,
        getAdminId:state=>state.adminId,
        getTypeList:state=>state.typeList,
        getProductList:state=>state.productList,
        getloginState:state=>state.loginState,
        getStuNumber:state=>state.stuNumber
    },

    // 通过commit mutations传递过来的方法和参数
    mutations:{
        SET_USERNAME(state,msg){
            state.userName = msg
        },

        SET_ADMINID(state,msg){
            state.adminId = msg
        },

        SET_TYPELIST(state,msg){
            state.typeList = msg
        },
        SET_PRODUCTLIST(state,msg){
            state.productList = msg
        },
        SET_LOGINSTATE(state,msg){
            state.loginState = msg
        },
        SET_STUNUMBER(state,msg){
            state.stuNumber = msg
        },


    },
    //通过dispatch传递过来的方法和参数  
    actions:{
        savaUserName(context,msg){
            context.commit("SET_USERNAME",msg)
        },
        savaAdminId(context,msg){
            context.commit("SET_ADMINID",msg)
        },
        savaTypeList(context,msg){
            context.commit("SET_TYPELIST",msg)
        },
        savaProductList(context,msg){
            context.commit("SET_PRODUCTLIST",msg)
        },
        savaLoginState(context,msg){
            context.commit("SET_LOGINSTATE",msg)
        },
        savaStuNumber(context,msg){
            context.commit("SET_STUNUMBER",msg)
        },
    }
})

// 导出store
export default store;