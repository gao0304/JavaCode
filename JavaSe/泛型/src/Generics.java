/*
注意的点：
1.泛型的E是一个类型变量，有其作用域
     类名称后面的是定义类型变量，其余位置都是使用
2.泛型是编译期间的工作
3.谁是谁的父类问题(需要使用通配符来确定父子类型)
list<Object>不是List<String>的父类
List<?>是List<String>的父类
 */
public class Generics {
    private static class Person<T>{
        T name;
        //static T age;  被静态修饰后是无法使用泛型的，静态方法、内部类也是如此
        T getName(){
            return name;
        }
    }

    public static void main(String[] args) {
        Person<String> p=new Person<>();
        String ps=p.getName();
        Person<Integer> q=new Person<>();
    }
}
