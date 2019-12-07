//和树没关系，作为练习异常的代码
public class Main {
    public static void throwExceptionMethod(boolean isThrow){
        System.out.println("抛异常之前");
        if(isThrow){
            throw new NullPointerException();
        }
        //如果catch那里捕获到了异常，这里就不会往下走了
        System.out.println("抛异常之后");
    }
    public static void main(String[] args) {
        try{
            throwExceptionMethod(true);
        }catch (NullPointerException a){  //这里要和抛出的异常匹配上才行
            System.out.println("捕获到异常");
        }
        //如果捕获到了异常，就输出{}里边的内容
        //如果没有捕获的话，就会终止程序，打印出错误信息
        finally {
            System.out.println("最终要来这里");
        }
    }
}
