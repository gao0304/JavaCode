/**
 * [编程题]无缓存交换
 * 请编写一个函数，函数内不使用任何临时变量，直接交换两个数的值。
 *
 * 给定一个int数组AB，其第零个元素和第一个元素为待交换的值，请返回交换后的数组。
 *
 * 测试样例：
 * [1,2]
 * 返回：[2,1]
 */
//方法:ab互相异或得出
public class Exchange {
    public static int[] exchangeAB(int[] AB) {
        AB[0]=AB[0]^AB[1];
        AB[1]=AB[0]^AB[1];
        AB[0]=AB[0]^AB[1];
        return AB;
    }

    public static void main(String[] args) {
        int[] AB={2,5};
        exchangeAB(AB);
        System.out.println(AB[0]+" "+AB[1]);
    }
}