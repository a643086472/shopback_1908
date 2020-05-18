package com.aishang.shopback_1908;

import com.aishang.shopback_1908.interceptor.SessionInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootConfiguration
public class WbeMvcConfig implements WebMvcConfigurer {

    /**
     * @author 周城
     * @date 2020/1/8 13:42
     * @param 相对路径
     */
    @Value("${file.staticAccessPath}")
    private  String staticAccessPath;
    /**
     * @author 周城
     * @date 2020/1/8 13:43
     * @param 不绝对路径
     */
    @Value("${file.uploadFolder}")
    private  String uploadFolder;

    @Resource
    private SessionInterceptor sessionInterceptor;

    /**
     * @author 周城
     * @date 2020/1/8 11:54
     * @param 拦截器
     */
    /*@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/adminUser/login").excludePathPatterns("/images/**");
    }*/

    /**
     * @author 周城
     * @date 2020/1/8 11:54
     * @param 静态资源映射
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(staticAccessPath).addResourceLocations("file:" + uploadFolder);
    }
}
