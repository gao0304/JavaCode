package gaofeng.ioc;

import gaofeng.scan.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        //加载Spring的配置文件，初始化上下文：生成Bean对象等等
        ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");
        // 新增这里
       /* Object o = context.getBean("myName");
        System.out.println(o.getClass());
        System.out.println(o);*/

     /*   Object o = context.getBean("duck");
        System.out.println(o.getClass());
        System.out.println(o);*/
/*
        //通过Bean的id来获取对象
        Object duck1 = context.getBean("duck1");
        System.out.println(duck1.getClass());
        System.out.println(duck1);

        Object duck2 = context.getBean("duck2");
        System.out.println(duck2.getClass());
        System.out.println(duck2);*/

        Object duckShop = context.getBean("duckShop");
        System.out.println(duckShop.getClass());
        System.out.println(duckShop);

        //通过类来获取对象，但是如果容器中只能有多个该类型的对象的时候（参照容器里的duck1和duck2）就不能通过这种方式来获取了，也就是容器中只能有一个该类型的对象
        Object duckShop2 = context.getBean(DuckShop.class);
        System.out.println(duckShop2.getClass());
        System.out.println(duckShop2);

        System.out.println(duckShop==duckShop2); //duckShop是使用单例模式获取的对象，duckShop2是使用原型模式获取的对象
        LoginController loginController =(LoginController) context.getBean("loginController");
        System.out.println(loginController.getLoginService());
        System.out.println(loginController.getDuck7());


    }
}
