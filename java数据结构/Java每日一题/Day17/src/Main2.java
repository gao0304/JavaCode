/**
 * [编程题]火车进站
 * 链接：https://www.nowcoder.com/questionTerminal/97ba57c35e9f4749826dc3befaeae109?orderByHotValue=1&questionTypes=000100&done=0&pos=10&mutiTagIds=581&onlyReference=false
 * 来源：牛客网
 * 给定一个正整数N代表火车数量，0<N<10，接下来输入火车入站的序列，一共N辆火车，
 * 题目描述：每辆火车以数字1-9编号。要求以字典序排序输出火车出站的序列号
 *
 * 思路：
 *     此处所谓字典序排序的意思是这n辆火车有多少种出站的可能顺序（也就是数据结构中的栈有多少种出栈顺序）。
 * 思路为用三个变量分别存储待进站火车，站中火车和已出站火车，其中待进站火车用Queue（队列）存储和站中
 * 火车采用stack（栈）存储，已出站火车采用StringBuilder来存储，具体实现是采用递归的方法，递归函数
 * 的参数为当前待进站火车、站中火车、已出站火车的值所组成的三元组，递归结束条件是，未进站火车和站中火
 * 车均为空，此时输出已出站火车即为所有出站的一种可能，递推关系为对于当前情况有让下一辆火车进站或让站
 * 中的一辆火车出站两种可能，对于两种可能分别调用递归函数，即可得出问题的解。
 *
 * 输入描述:
 * 有多组测试用例，每一组第一行输入一个正整数N（0<N<10），第二行包括N个正整数，范围为1到9。
 *
 * 输出描述:
 * 输出以字典序从小到大排序的火车出站序列号，每个编号以空格隔开，每个输出序列换行，具体见sample。
 *
 * 示例1
 * 输入
 * 3
 * 1 2 3
 *
 * 输出
 * 1 2 3
 * 1 3 2
 * 2 1 3
 * 2 3 1
 * 3 2 1
 */

import java.util.*;

public class Main2 {
    private static List<int[]> list=new ArrayList<>();//存放所有可能的出栈序列【不一定合法】
    private static List<String> res=new ArrayList<>();//存放最终所有合法的出栈序列

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            backTrace(n, arr, 0);//先输出所有的排列组合
            //此时list里存放的是所有可能的结果，遍历list进行筛选
            for (int[] t : list) {
                if (isLegal(arr, t, n)) {
                    String s = arrToStr(t, n);
                    res.add(s);
                }
            }
            /**
             *第三步：对所有合法的出栈序列按字典排序后进行输出
             */
            Collections.sort(res);
            for (String r : res) {
                System.out.println(r);
            }
        }
    }

    /**
     * 第一步：得到元素所有的的排列组合
     * 我们的想法是每次都把一个数固定在前面，让后面的数递归地进行全排列，这样每个数都固定过以后就能找出所有排列。
     * 关键的地方在于，我们把每个数固定在前面并让后面的进行全排列完毕以后，要恢复原来的状态，也就需要交换回来。
     * 就像遍历二叉树一样
     */

    private static void backTrace(int n, int[] arr, int beginIndex) {
        if (beginIndex == n - 1) {   //此时只剩下一个元素，不用再交换了
            int[] tmp = arr.clone(); //这里是对数组的深拷贝（对二维数组就成了浅拷贝）
            list.add(tmp); //每次此时所得数组存入集合list中
            return;
        }
        for(int i=beginIndex;i<n;i++){
            swap(arr,i,beginIndex); //交换它和它的下一个元素（包括它本身）
            backTrace(n,arr,beginIndex+1); //递归求后边的字符排列
            swap(arr,i,beginIndex); //恢复到上一步状态继续进行新的排列（关键）
        }
    }

    //交换函数
    private static void swap(int[] arr, int i, int beginIndex) {
        int tmp=arr[i];
        arr[i]=arr[beginIndex];
        arr[beginIndex]=tmp;
    }
    /**
     *第二步：进行筛选(挨个进一个序列，挨个判断一个序列的每个元素)
     *   1.将进栈的序列挨个压入栈中(一次只压一个，然后进行后边的判断)：
     *   如果栈顶元素和需要出站序列元素相同，说明这个元素需要出栈，那么，栈顶元素出栈，同时出栈序列向后走一步,继续做比较;
     *   如果不相同,继续把进栈的序列元素给压入栈中.
     *   2.直到进栈序列的元素全部压进栈中.
     *   3.如果循环完毕后栈为空，说明进去的全部出去了符合预期；否则，出栈序列不符合进栈出栈的规则，pass掉.
     */
    private static boolean isLegal(int[] in, int[] out, int n) {
        Stack<Integer> stack=new Stack<>();
        int j=0;
        for(int i=0;i<n;i++){
            stack.push(in[i]);
            //peek()是查看栈顶元素，pop是删除栈顶元素
            while(j<n&&!stack.isEmpty()&&out[j]==stack.peek()){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    private static String arrToStr(int[] t, int n) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(t[i]);
            if(i!=n-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
