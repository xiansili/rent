const SERVERURL = 'http://localhost:8085/';//后台服务端URL

const URL = {
    getVarietyItem: SERVERURL + 'getVarietyItem',
    // 获取热门商品
    getHotProduct: SERVERURL + 'getHotProduct',
    // 用户注册
    registUser: SERVERURL + 'user/registUser',
    // 用户登录
    loginUser: SERVERURL + 'user/loginUser',
    // 获取商品类型
    getTypes: SERVERURL + 'type/getTypes',
    // 根据分类名称获取商品类型
    getAllTypes: SERVERURL + 'type/getAllTypes',
    //根据类型获取商品 
    getProductsByType: SERVERURL + 'product/getProductsByType',
    // 获取商品详情
    getDetail: SERVERURL + 'product/getDetail',
    // 加入购物车
    addCart: SERVERURL + 'cart/addCart',
    // 获取购物车信息
    getCart: SERVERURL + 'cart/getCart',
    // 发布商品信息
    publish:SERVERURL + 'publish',
    // 添加个人信息
    addUserInfo:SERVERURL + 'user/addUserInfo',
    // 修改个人信息
    updateUsreiofo:SERVERURL + 'user/updateUsreiofo',
    // 获取个人信息
    getUserInfo:SERVERURL + 'user/getUserInfo'
};

export default URL;