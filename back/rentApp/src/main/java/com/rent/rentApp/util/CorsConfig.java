package com.rent.rentApp.util;

        import org.springframework.context.annotation.Configuration;
        import org.springframework.web.servlet.config.annotation.CorsRegistry;
        import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CorsConfig extends WebMvcConfigurationSupport {

    /**
     * 全局配置 axios 跨域请求
     * addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径
     * allowedOrigins：允许所有的请求域名访问跨域资源，可以固定单条或者多条内容，
     * 如：”http://www.xxx.com“，只有该域名可以访问我们的跨域资源
     * allowCredentials：是否允许用户发送、处理 cookie
     * allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等
     * allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息
     * maxAge：预检请求的有效期，单位为秒。有效期内，不会重复发送预检请求
     * 当预检请求通过后，浏览器会发送真实请求到服务器。这就实现了跨域请求
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins = {"http://localhost:8080"};
        registry.addMapping("/**")
                .allowedOrigins(origins)
                .allowCredentials(true)
                .allowedMethods("*")
                .allowedHeaders("*")
                .maxAge(3600);
    }
}

//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.CorsFilter;
//
///**
// * 实现基本的跨域请求
// * @author linhongcun
// *
// */
//@Configuration
//public class CorsConfig {
//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("http://localhost:8080"); // 允许任何域名使用
//        corsConfiguration.addAllowedHeader("*"); // 允许任何头
//        corsConfiguration.addAllowedMethod("*"); // 允许任何方法（post、get等）
//        return corsConfiguration;
//    }
//
//    @Bean
//    public CorsFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/departname/**", buildConfig()); // 对接口配置跨域设置
//        return new CorsFilter(source);
//    }
//}