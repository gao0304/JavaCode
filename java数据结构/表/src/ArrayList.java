import java.rmi.ServerError;
import java.sql.SQLOutput;

public class ArrayList {
    //第一步：定义属性
    private int[]array;  //定义一个数组
    private int size;    //size为当前数组存在数据的大小
    //第二步：构造方法
    public ArrayList(){
     array=new int[3];  //申请空间
     size=0;   //初始化数据个数为0
    }
    //尾插
    public void pushBack(int element){
        ensureCapacity();
        array[size++]=element;
    }
    //头插
    public void pushFront(int element){
        ensureCapacity();
        for(int i=size-1;i>=0;i--){
            array[i+1]=array[i];
        }
        array[0]=element;
        size++;
    }
    //中间插
    public void insert(int index,int element){
        ensureCapacity();
        for(int i=size-1;i>=index;i--){
            array[i+1]=array[i];
        }
        array[index]=element;
        size++;
    }
    //尾删
    public void popBack(){
        if(size<0){
            System.err.println("顺序表为空");
        }
        size--;
    }
    //头删
    public void popFront(){
        if(size<0){
            System.err.println("顺序表为空");
        }
        for(int i=1;i<size;i++){
            array[i-1]=array[i];
        }
        size--;
    }
    //中间删除
    public void earse(int index){
        if(size<0){
            System.err.println("顺序表为空");
        }
        if(index<0||index>=size){
            System.err.println("下标错误");
        }
        for(int i=index+1;i<size;i++){
            array[i-1]=array[i];
        }
        size--;
    }
    //查找
    public int indexOf(int element){
        for(int i=0;i<size;i++){
            if(array[i]==element){
                return i;
            }
        }
        return -1;
    }
    //修改
    public int set(int index,int element){
        if(index<0||index>=size){
            System.err.println("下标错误");
        }
        array[index]=element;
        return array[index];
    }
    //删除第一次出现的某一个元素
    public void remove(int element){
        int index=indexOf(element);
        if(index!=-1){
            earse(index);
        }
    }
    //删除出现全部的某一个元素
    public void removeAll(int element){  //时间复杂度为O（n^3）太大了
        for(int i=0;i<size;i++){
            int index=indexOf(element);
            if(index!=-1){
                earse(index);
            }
            }
        }
    public void removeAll2(int element){//时间复杂度为O（n^2）太大了
        int index=0;
        while((index=indexOf(element))!=-1){
            earse(index);
        }
    }
    public void removeAll3(int element){//时间复杂度为和空间复杂度均为O（n）
        //这里是创建了一个新的数组，把不重复的复制到新的数组，说移是不准确的
        int[] newArray=new int [array.length];
        int j=0;
        for(int i=0;i<size;i++){
            if(array[i]!=element){
                newArray[j++]=array[i];
            }
        }
        array=newArray;
        size=j;
    }
    public void removeAll4(int element){//时间复杂度为O(n)，空间复杂度为O(1)，为最好的算法
        //在原数组下进行操作，遇到重复的就跳过
        int i=0,j=0;
        for(i=0;i<size;i++){
            if(array[i]!=element){
                array[j++]=array[i];
            }
        }
        size=j;
    }
    //扩容
    private void ensureCapacity(){
        if(size<array.length){  //这里不能写成size<=array.lengh因为这样当数组容量=size时会导致无法扩容
            return;
        }
        int newCapacity=array.length*2;
        int[] newArray=new int[newCapacity];
        for(int i=0;i<size;i++){
            newArray[i]=array[i];
        }
        array=newArray;
    }
    //打印
    public void print(){
        System.out.println("打印顺序表： ");
        for(int i=0;i<size;i++){
            System.out.print(array[i]+"  ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        ArrayList list1=new ArrayList();
        list1.pushBack(1);
        list1.pushBack(2);
        list1.pushBack(3);
        System.out.print("验证尾插"+"  ");
        list1.print();
        //预期结果：1  2  3
        list1.pushFront(10);
        list1.pushFront(20);
        list1.pushFront(30);
        System.out.print("验证头插"+"  ");
        list1.print();
        //预期结果：30  20  10  1  2  3
        list1.insert(3,100);
        list1.insert(3,100);
        list1.insert(3,200);
        System.out.print("验证中间插"+"  ");
        list1.print();
        //预期结果：30  20  10  300  200  100  1  2  3
        list1.popBack();
        list1.popBack();
        list1.popBack();
        System.out.print("验证尾删"+"  ");
        list1.print();
        //预期结果：30  20  10  300  200  100
        list1.popFront();
        System.out.print("验证头删"+"  ");
        list1.print();
        //预期结果：20  10  300  200  100
        list1.earse(3);
        System.out.print("验证中间删"+"  ");
        list1.print();
        //预期结果：20  10  300  100
        System.out.print("验证删除元素"+"  ");
        list1.removeAll4(100);
        list1.print();
    }
}
