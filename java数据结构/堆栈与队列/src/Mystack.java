import java.lang.reflect.Array;

/*
栈用顺序表实现相对简单一点
用尾删和尾插这样时间复杂度为O(1)效率高
 */
class Stack{
    private int []array;//存数据的空间
    private int top;  //表示当前栈内的元素个数

    public Stack(int defaultCapacity){
        array=new int[defaultCapacity];
        top=0;
    }
    public Stack(){
        this(1);
    }
    //扩容
    public void ensureCapacity(){
        if(top<array.length){
            return;
        }
        int[] newArray=new int[array.length*2];
        for(int i=0;i<top;i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }
    //判断栈是否是满的
    public boolean isFull(){
        if(top==20){
            return true;
        }
        return false;
    }
    //尾插
    public char push(int val){
        ensureCapacity();
        array[top++]=val;
        return 0;
    }
    //尾删
    public void pop(){
        if(top<=0){
            System.err.println("无法删除空栈");
        }
        array[top--]=0;
    }
    //返回栈顶元素(不出栈)
    public int peek() {
        if (top <= 0) {
            System.err.println("空栈无法返回栈顶元素");
        }
        return array[top - 1];
    }
    //返回栈顶元素(出栈)
    public int top() {
        if (top <= 0) {
            System.err.println("空栈无法返回栈顶元素");
        }
        return array[--top];
    }
    //返回栈内元素个数
    public int size(){
        return top;
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return top==0;
    }
    //打印
    public void print(){
        for(int cur=0;cur<top;cur++){
            System.out.print(array[cur]+"   ");
        }
        System.out.println();
    }
}
public class Mystack{
    //主函数
    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.print();   //1 2 3
        System.out.println(stack.top());  //返回栈顶元素出栈  3
        stack.print();  //1  2
        System.out.println(stack.peek()); //返回栈顶元素不出栈  2
        stack.print();  // 1  2
        stack.pop();
        stack.print();  // 1
    }

}