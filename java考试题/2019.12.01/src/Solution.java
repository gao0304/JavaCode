/**
 * [编程题]合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    /**
     *递归版本：
     合并过程中，首先比较两个链表的首节点哪个小，较小的节点作为合成链表的首节点，
     之后将指针指向较小节点的后一个节点，再次进行上面逻辑的比较，可以发现比较过程是一个递归的操作。
     */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        //通过递归到最大的节点，并进行返回递归操作到上一次递归的空间，
        // 将返回节点作为当前次大节点的下一个节点，这样从后到前返回到第一个节点的空间，递归操作完成。
        if(list1.val<=list2.val){
            list1.next=Merge1(list1.next,list2);
            return list1;
        }else {
            list2.next=Merge1(list1,list2.next);
            return list2;
        }
    }

    /**
     *迭代版本:
     *新建一个链表，然后遍历原来的那两个链表，具体步骤看下边
     */
    public ListNode Merge2(ListNode list1,ListNode list2) {
        //为了等会尾插方便，事先建立一个头结点，用来存合并以后的链表
        ListNode result=new ListNode(-1);
        ListNode newHead=result;//为了输出时方便输出（提前用一个节点记录头结点）
        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        while(list1!=null&&list2!=null){
            if(list1.val<=list2.val){
                //如果当前list1.val<=list2.val，复制list1.val结点并将其插入到result后边，
                // 然后移动result指针，同时遍历list1的下一个元素
                ListNode node=new ListNode(list1.val);
                result.next=node;
                list1= list1.next;
                result=result.next;
            }else {
                //如果当前list1.val>list2.val，复制list2.val结点并将其插入到result后边，
                // 然后移动result指针，同时遍历list2的下一个元素
                ListNode node=new ListNode(list2.val);
                result.next=node;
                list2=list2.next;
                result=result.next;
            }
        }
        //进行到这里后，可能list1或者list2没有遍历完，那么要进行判断，也就是把未结束的链表连接到合并后的链表尾部
        if(list1==null){
            result.next=list2;
        }
        if(list2==null){
            result.next=list1;
        }
        return newHead.next;  //返回事先记录好的节点，跳过那个自己建立的第一个节点输出
    }
}