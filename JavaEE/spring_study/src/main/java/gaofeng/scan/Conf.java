package gaofeng.scan;

import gaofeng.ioc.Duck;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration //注册配置类
public class Conf {
    @Bean  //注册自己定义的Bean
    public Duck duck3(){
        return new Duck("duck3333");
    }
    @Bean("duck4")
    public Duck duck44444(){
        return new Duck("唐老鸭");
    }
}
