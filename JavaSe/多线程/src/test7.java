/**
 * 线程并发和串行模式运行时间的对比
 * 不一定有线程快
 */
public class test7 {
    private static final long count=10_0000_0000;

    public static void main(String[] args) throws InterruptedException{
        concurrency();
        serial();

    }
    //使用并发模式
    private static void concurrency() throws InterruptedException {
        long begin=System.nanoTime();
        //利用一个线程来计算a的值
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int a=0;
                for(long i=0;i<count;i++){
                    a--;
                }
            }
        });
        thread.start();
        //在主线程里计算b的值
        int b=0;
        for(long i=0;i<count;i++){
            b--;
        }
        thread.join();
        long end=System.nanoTime();
        double ms = (end - begin) * 1.0 / 1000 / 1000;
        System.out.printf("并发: %f 毫秒%n", ms);
    }

    //使用串行模式
    private static void serial() {
        long begin=System.nanoTime();
        int a=0;
        for(long i=0;i<count;i++){
            a--;
        }
        int b=0;
        for(long i=0;i<count;i++){
            b--;
        }
        long end=System.nanoTime();
        double ms = (end - begin) * 1.0 / 1000 / 1000;
        System.out.printf("串行: %f 毫秒%n", ms);
    }
}
