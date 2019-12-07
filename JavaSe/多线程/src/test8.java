/**
 * 创建线程的方法
 */

public class test8 {
    //创建线程方法1
    private static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("运行的代码");
        }
    }
    //创建线程方法2
    private static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"运行的代码");
            //这里需要通过Thread.currentThread()来获取当前线程的引用
        }
    }
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();

        Thread t2=new Thread(new MyRunnable());
        t2.start();

        //变形1：使用匿名类来创建Thread子类对象
        Thread t3=new Thread(){
            @Override
            public void run() {
                System.out.println("使用匿名类创建 Thread 子类对象");
            }
        };

        //变形2：使用匿名类创建Runnable子类对象
        Thread t5=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名类创建 Runnable 子类对象");
            }
        });
        //变形3：使用lambda表达式创建Runnable子类对象
        Thread t4=new Thread(() ->{
            System.out.println("使用匿名类创建 Thread 子类对象");
        });
    }
}
