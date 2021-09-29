package com.demo.shiro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 */
//@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 注册拦截器
     *
     * @param registry 映射列表注册
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册需要排除拦截的url
       /* registry.addInterceptor(new RequestInterceptor()).excludePathPatterns(new LinkedList<String>() {{
            // 静态资源url
            add("/v2/**");
            add("/webjars/**");
            add("/doc.html/**");
            add("/swagger-ui.html/**");
            add("/swagger-resources/**");
            // 请求url
        }});
        // 注册需要拦截的url
        registry.addInterceptor(new RequestInterceptor()).addPathPatterns(new LinkedList<String>() {{
            // 请求url
            add("/admin/**");
        }});*/
    }

    /**
     * 添加处理程序服务静态资源.
     *
     * @param registry 资源处理注册
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    /** 解决跨域问题 **/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
                // 允许跨域访问的路径
        registry.addMapping("/**")
                // 允许跨域访问的源
                .allowedOrigins("*")
                // 允许请求方法
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                // 预检间隔时间
                .maxAge(168000)
                // 允许头部设置
                .allowedHeaders("*")
                // 是否发送cookie
                .allowCredentials(true);
    }
}
