package frank;

import frank.model.Duck;
import frank.model.DuckShop;
import frank.model.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        //从容器中获取Bean对象
        Duck duck1 = (Duck) context.getBean("duck1");
//        System.out.println(duck1);

        Duck duck2 = (Duck) context.getBean("duck1");
//        System.out.println(duck2);

        DuckShop duck3 = (DuckShop) context.getBean("duckShop");
//        System.out.println(duck3);

        //通过类型在容器中获取Bean时，要求该类型只有一个对象在容器中，否则会报错
        Person duck4 = context.getBean(Person.class);
//        System.out.println(duck4);

        Duck duck5 = (Duck) context.getBean("duck3");
//        System.out.println(duck5);

        Duck duck6 = (Duck) context.getBean("duck5");
//        System.out.println(duck6);
    }
}