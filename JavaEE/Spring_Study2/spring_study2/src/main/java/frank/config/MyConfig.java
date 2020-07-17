package frank.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  //对配置类的注解
public class MyConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加一个拦截器
        registry.addInterceptor(new LoginInterceptor()) //所有匹配到的路径，都会进入拦截器
        .addPathPatterns("/1/**") // **代表所有的子路径，*只匹配一级路径   addPathPatterns是添加需要拦截的路径
        .excludePathPatterns("/1/login6");  //排除我们不想拦截的路径
    }
}
