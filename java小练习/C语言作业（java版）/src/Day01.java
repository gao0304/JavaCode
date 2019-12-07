public class Day01 {
    //1. 打印100~200 之间的素数
    //(1)最直接想到的办法
    public static void primeNumber1(){
        int count=0;
        for(int i=100;i<=200;i++){
            int j=2;
            for(;j<=i;j++){
                if(i%j==0) {
                    break;
                }
            }
            if(j==i){
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
    /*
    (2)(第一种的优化版)
    原理：任何一个数，它的每一对因子都是由这个数开平方后的数的左右各一个组成，
    所以，在求余过程中，我们只需要对从2到开平方之后的数求余即可。
     */
    public static void primeNumber2(){
        int count=0;
        for(int i=100;i<=200;i++){
            int j=2;
            for(;j<=Math.sqrt(i);j++){  //区别在这里
                if(i%j==0) {
                    break;
                }
            }
            if(j>Math.sqrt(i)){
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
    /*
    (3)(第二种的优化版)
    我们知道偶数肯定不是素数，所以我们只在奇数中找素数
     */
    public static void primeNumber3(){
        int count=0;
        for(int i=101;i<=200;i+=2){  //注意：这里的i得从101开始
            int j=2;
            for(;j<=Math.sqrt(i);j++){  //区别在这里
                if(i%j==0) {
                    break;
                }
            }
            if(j>Math.sqrt(i)){
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
    //2.输出乘法口诀表
    public static void multiplication(){
        int result;
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                result=i*j;
                System.out.print(j+"*"+i+"="+result+" ");
            }
            System.out.println();
        }
    }
    //3.判断1000年---2000年之间的闰年
    public static void leapYear(){
        int count=0;
        for(int i=1000;i<=2000;i++){
            if((i%4==0&&i%100!=0)||(i%400==0)){
                System.out.println(i);
                count++;
            }
        }
        System.out.println(count);
    }
    public static void main(String[] args) {
        //primeNumber1();
        // primeNumber2();
        //primeNumber3();
        //multiplication();
        //leapYear();
    }
}
