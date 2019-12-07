public class testDemo {
    public static void main(String[] args) {
        mySort testSort=new mySort();
        int[] array={8,11,2,4,6,3,7,1};
      /* testSort.insertSort(array);
        testSort.show(array);
        testSort.shellSort(array);
        testSort.show(array);
        testSort.selectSort(array);
        testSort.show(array);
        testSort.heapSort(array);
        testSort.show(array);
        testSort.quickSort(array);
        testSort.show(array);
        testSort.bubbleSort(array);
        testSort.show(array);*/
        testSort.mergeSort(array);
        testSort.show(array);
    }
}
