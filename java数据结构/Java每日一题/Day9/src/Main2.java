/**
 [编程题]末尾0的个数
 方法2：我们知道哦按段一个数有没有0时可以通过被2整除或者被5整除判断
 （因为10只能有2*5或者5*2得到），但是用2整除的话就会除很多次，所以
 这里不用傻乎乎的真的去求一个数的阶乘，只要判断它是不是能被5整除就行
 了。
 */
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = n; i >= 5; i--) {
        //i<5的时候肯定不能被5整除，因为判断的是一个数的阶乘的值中的0，所以每次要--
            int tmp = i; //用临时变量保存下来进行除5操作
            while(tmp % 5 == 0) {
                res++;
                tmp /= 5;
            }
        }
        System.out.println(res);
    }
}
