package frank.config;

import frank.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Date;

@Configuration  //对配置类的注解
public class MyConfig implements WebMvcConfigurer {
    //WebMvcConfigurer 是做WebMVC的配置，可以重写接口方法，如添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加一个拦截器
        registry.addInterceptor(new LoginInterceptor()) //所有匹配到的路径，都会进入拦截器
        .addPathPatterns("/1/**") // **代表所有的子路径，*只匹配一级路径   addPathPatterns是添加需要拦截的路径
        .excludePathPatterns("/1/login6");  //排除我们不想拦截的路径
    }

    @Bean //建议到Configuration注解中使用
    //定义一个名称为user1的user对象，并注册到容器中
    public User user1(){
        User user =new User();
        user.setUsername("你好啊1号");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    @Bean
    public User user2(){
        User user =new User();
        user.setUsername("你好啊2号");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }

    //假如要使用其他的一些bean对象（这里假如是user1），怎么设置到当前的user3里取呢？看下边的写法
    @Bean
    public User user3(@Qualifier("user1") User user1){
        System.out.println(user1);
        User user =new User();
        user.setUsername("你好啊3号，我借用了一下1号bean对象");
        user.setPassword("123");
        user.setBirthday(new Date());
        return user;
    }
}
