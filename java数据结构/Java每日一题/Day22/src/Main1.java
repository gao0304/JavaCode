/**
 *[编程题]链式A+B
 * 链接：https://www.nowcoder.com/questionTerminal/ed85a09f0df047119e94fb3e5569855a
 * 来源：牛客网
 *
 * 有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 * 给定两个链表ListNode* A，ListNode* B，请返回A+B的结果(ListNode*)。
 *
 * 测试样例1：
 * {1,2,3},{3,2,1}
 *
 * 返回：{4,4,4}
 *
 * 用例2:
 * {7,4,0,7,5},{2,7,2,3,4}
 *
 * 对应输出应该为:
 *
 * {9,1,3,0,0,1}
 */
/**
 本题思路：按照小学数学中学习的加法原理从末尾到首位，对每一位对齐相加即可。
 技巧在于如何处理不同长度的数字，以及进位和最高位的判断。
 这里对于不同长度的数字，我们通过将较短的数字补0来保证每一位都能相加。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main1 {
    public static ListNode plusAB(ListNode a, ListNode b) {
        ListNode result=new ListNode(-1);//为了等会尾插方便，事先建立一个头结点，用来保存结果的链表
        ListNode newHead=result;//为了输出时方便输出（提前用一个节点记录头结点）
        int c=0,val1,val2,sum; //c是每一位数字除以10的结果，val1是链表a的节点的值，val2是链表b的节点的值
        //这里加入c!=0是为了防止加最后一位数时恰好到了10，然后输出的时候不让它漏掉1
        while(a!=null||b!=null||c!=0){
            //这里的三目表达式是为了防止有一个链表比较短，如果有一个先遍历完了之后后边的位置用0代替直到另一个也遍历完
             val1=(a==null?0:a.val);
             val2=(b==null?0:b.val);
             sum=val1+val2+c; //准备进行进位操作
             c=sum/10;
             ListNode node=new ListNode(sum%10);
             //大于10把大于10的那部分放进去，小于等于10把本来的和放进去
             result.next=node;
             result=result.next; //result向后移动一位
             a=(a==null?null:a.next); //这里是为了防止a==null，然后造成空指针异常
             b=(b==null?null:b.next); //同上
        }
        return newHead.next;//返回事先记录好的节点，跳过那个自己建立的第一个节点输出
    }
}
