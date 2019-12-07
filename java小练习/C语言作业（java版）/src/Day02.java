public class Day02 {
    //1.交换两个数
    //(1)不创建新的临时变量
    public static void swap1(int a,int b){
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("a="+a+"  "+"b="+b);
    }
    //(2)交换两个数(异或的方法，更高效)
    public static void swap2(int a,int b){
        a=a^b;
        b=a^b;
        a=a^b;
        System.out.println("a="+a+"  "+"b="+b);
    }
    //2.求10个整数中最大值
    public static int max(int [] arr){
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    //3.将三个数按从大到小输出


    //4.求两个数的最大公约数
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int[] arr={2,55,4,5,3,1,5,2,15,2};
        swap2(a,b);
        /*System.out.println("交换前： a = " + a + "； b = " + b);
        swap1(a, b);
        System.out.println("交换后： a = " + a + "； b = " + b);*/
        System.out.println(max(arr));
    }
}
