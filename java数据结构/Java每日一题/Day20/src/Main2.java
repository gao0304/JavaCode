/**
 * [编程题]链表分割
 * 链接：https://www.nowcoder.com/questionTerminal/0e27e0b064de4eacac178676ef9c9d70?mutiTagIds=639&orderByHotValue=1&questionTypes=000100&commentTags=Python
 * 来源：牛客网
 *
 * 编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
 *
 * 给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
 */

/**
 *
 * 思路：创建一个新的链表，以x为分割线，遍历原来的链表，将比x小的放在左边，大的放在右边
 * 说明一下这里可能有的人会想直接在原本的链表上修改行不行,答案是可行的（不过比较复杂，这里说明一下原因）
 *  原因：应题目上的要求，写的代码里边肯定要涉及到两个节点位置的互换，那互换两个节点有需要什么呢？
 *     假设我们有a,b两个节点，要交换这两个节点因为是在链表上进行，我们是不能直接交换的，必须要用到a的前一个节点和b的后一个节点
 *     比如是这样  A--a--b--B--null,要交换a,b
 *     所写的代码为 a.next=B; b.next=a; A.next=b; 然后从A开始遍历
 *     假如题上给出的节点是{3，5，2，6}以4为临界点考虑是{3,2,5,6}这种还好，不用涉及到边界的互换
 *       但是如果是{5,6,2,1}以4为临界点是要涉及到临界的互换的，所以写起来代码会很麻烦，故不推荐
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Main2 {
    public ListNode partition(ListNode pHead,int x){
        //链表没有节点的时候直接返回null
        if(pHead==null){
            return null;
        }
        //链表只有一个节点的时候直接返回那个节点
        if(pHead.next==null){
            return pHead;
        }
        //创建x节点作为分割前半部分和后半部分的中间节点
        ListNode nodex=new ListNode(x);
        //创建newHead方便第一个小于x值的插入
        ListNode newHead=new ListNode(0);
        newHead.next=nodex;
        //创建before结点，在迭代过程中始终保持before.next=nodex
        //从而保证小于x值的结点可以插入到nodex结点之前
        ListNode before=newHead;
        //创建after结点，在迭代过程中始终保持after结点是最后一个结点
        //从而保证大于等于x值的结点可以插入链表的最后位置
        ListNode after=nodex;
        ListNode walk=pHead;
        while(walk!=null){//开始遍历原链表
            //如果当前节点小于x，复制结点并将其插入到xnode的前一个结点，然后移动before指针
            if(walk.val<x){
                ListNode node=new ListNode(walk.val);
                before.next=node;
                node.next=nodex;
                before=node;
            }
            //如果当前节点大于x，复制结点并将其插入到链表最后一个结点，然后移动after指针
            else if(walk.val>=x){
                ListNode node=new ListNode(walk.val);
                after.next=node;
                after=node;
            }
            walk=walk.next;
        }
        //这里要忽略自建的x结点nodex和头结点newHead，因为x结点不一定存在于原链表，所以此处要将分开的前后部分相连
        before.next=nodex.next;
        return newHead.next;
    }
}
