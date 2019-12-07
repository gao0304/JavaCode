public class TestDemo {
    public static void main(String[] args) {
        MyHeap testHeap=new MyHeap();
        int[] array={1,2,3,4,5,6,7,8,9,10};
        testHeap.initHeap(array);
        testHeap.show();
        testHeap.pushHeap(11);
        testHeap.show();
        testHeap.popHeap();
        testHeap.show();
        testHeap.getHeapTop();
        testHeap.show();
    }
}
