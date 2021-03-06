package com.halo.config;

import com.halo.interceptor.SessionVerifyInterceptor;
import com.halo.interceptor.TokenVerifyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author MelloChan
 * @date 2018/5/1
 */
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
    @Bean
    public TokenVerifyInterceptor tokenVerifyInterceptor() {
        return new TokenVerifyInterceptor();
    }

    @Bean
    public SessionVerifyInterceptor sessionVerifyInterceptor() {
        return new SessionVerifyInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*");
        super.addCorsMappings(registry);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenVerifyInterceptor())
                .addPathPatterns("/api/halo/**")
                .excludePathPatterns("/api/halo/auths/**")
                .excludePathPatterns("/api/halo/registers/**")
                .excludePathPatterns("/api/halo/items/**")
                .excludePathPatterns("/api/halo/categorys/**")
                .excludePathPatterns("/api/halo/carts/**")
                .excludePathPatterns("/api/halo/backstage/**");
        registry.addInterceptor(sessionVerifyInterceptor())
                .addPathPatterns("/api/halo/backstage/**")
                .excludePathPatterns("/api/halo/backstage/admins/**");
        super.addInterceptors(registry);
    }
}
