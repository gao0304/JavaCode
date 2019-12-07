/**
 * [编程题]删数
 * 链接：https://www.nowcoder.com/questionTerminal/f9533a71aada4f35867008be22be5b6e
 * 来源：牛客网
 *
 * 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，求最后一个被删掉的数的原始下标位置。以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 *
 * 输入描述:
 * 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。
 *
 * 输出描述:
 * 一行输出最后一个被删掉的数的原始下标位置。
 * 示例1:
 *
 * 输入
 * 8
 *
 * 输出
 * 6
 */
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Main1 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        if (n > 1000) {
            n = 999;
        }
        //deleteNumber1(n);
        deleteNumber2(n);
    }

    /**
     * 方法1：用一个线性表结合一个动态取下标的算法来实现，但是不太好想到
     */
    public static void deleteNumber1(int n) {
        List<Integer> list = new ArrayList<Integer>();
        //依次给表里添加元素
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i = 0;
        while (list.size() > 1) {
            i = (i + 2) % list.size();
            //核心：用取余的方式来获取要删除下标的位置，每次删除后list的大小都是变化的
            list.remove(i);
        }
        //while循环完后，list里边只剩下一个元素了
        System.out.println(list.get(0));
    }

    /**
     * 方法2：用队列模拟，队首取数，用一个计数器计数，隔2个删一个，其他的重新放到队尾(循环队列)
     */
    public static void deleteNumber2(int n) {
        Queue<Integer> queue=new LinkedBlockingDeque<Integer>();
        // LinkedBlockingQueue ：一个由链接节点支持的可选有界队列。
        for(int i=0;i<n;i++){
            queue.add(i);//依次给队列里添加元素
        }
        int count=0;
        while(queue.size()!=1){ //当队列里只剩一个元素的时候跳出循环
            if(count!=2){
                int b=queue.element(); //用临时变量b保存队首元素
                queue.poll();
                queue.add(b); //把对头元素放到队尾，实现循环队列
                count++;
            }else{
                queue.poll(); //删除需要删除的元素
                count=0; //准备进行下一轮循环
            }
        }
        //while循环完后，queue里边只剩下一个元素了
        System.out.println(queue.element());
    }
}
