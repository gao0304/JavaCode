/**
 *有关线程的中断操作
 */
public class test5 {
    //线程的中断方式1：通过共享的标记来进行沟通
    private static class MyRunnable implements Runnable {
        public volatile boolean isQuit = false;

        @Override
        public void run() {
            while (!isQuit) {
                System.out.println(Thread.currentThread().getName() + ": 别管我，我忙着转账呢!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + ": 啊！险些误了大事");
        }
    }
     //线程的中断方式2：通过调用interrupt()方法来通知
     private static class MyRunnable2 implements Runnable{

         @Override
         public void run() {
            // while(!Thread.interrupted()){//方式2—1：会清除异常的标志位
             while(!Thread.currentThread().isInterrupted()){ //方式2—2：不会清除异常的标志位
                 System.out.println(Thread.currentThread().getName() + ": 别管我，我忙着转账呢!");
                 try{
                     Thread.sleep(1000);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                     System.out.println(Thread.currentThread().getName() + ": 有内鬼，终止交易！");
                     break;
                 }
             }
             System.out.println(Thread.currentThread().getName()+"：啊！差一点啊我曹");
         }
    }

    public static void main(String[] args) throws InterruptedException {
        //方式1的主函数
        MyRunnable target=new MyRunnable();
        Thread thread=new Thread(target,"李四");
        System.out.println(Thread.currentThread().getName() + ": 让李四开始转账。");
        thread.start();
        Thread.sleep(10 * 1000);
        System.out.println(Thread.currentThread().getName() + ": 老板来电话了，得赶紧通知李四对方是个骗子！");
        target.isQuit=true; //在这里告知，但是当线程正在休眠的时候告知的话只能等他“起床”了在处理
        //方式2的主函数
        MyRunnable target2=new MyRunnable();
        Thread thread2=new Thread(target2,"李四");
        System.out.println(Thread.currentThread().getName() + ": 让李四开始转账。");
        thread.start();
        Thread.sleep(10 * 1000);
        System.out.println(Thread.currentThread().getName() + ": 老板来电话了，得赶紧通知李四对方是个骗子！");
        thread.interrupt();//在这里告知，即使线程在“休眠”也能强制把它叫醒
    }
}
