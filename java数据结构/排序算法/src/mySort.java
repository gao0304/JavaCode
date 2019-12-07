public class mySort {
    //直接插入排序
    void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }
    //希尔排序(优化版的插入排序)
    void shellSort(int[] array){
        int gap=array.length;
        while(gap>1){
            insertSortGap(array,gap);
            gap=(gap/3)+1;
        }
        if(gap==1){
            insertSortGap(array,gap);
        }
    }
    //希尔排序的原理
    void insertSortGap(int[] array,int gap){
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j;
            for (j = i - gap; j >= 0; j-=gap) {
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    break;
                }
            }
            array[j + gap] = tmp;
        }
    }
    //选择排序
    void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    swap(array,i,j);
                }
            }
        }
    }
    //堆排序(排升序建大堆，排降序建小堆)(所以整体的时间复杂度为O(nlog2^n)，空间复杂度为O(1))
    void heapSort(int[] array){
        creatHeap(array);
        for(int j=0;j<array.length-1;j++){
            swap(array,0,array.length-1-j);
            shiftDown(array,0,array.length-1-j-1);
            //这里end:array.length-1-j-1还要减一是因为上面已经发生了交换，不算做下一次调整的结尾
        }
    }
    //建堆(时间复杂度为n/2)
    private void creatHeap(int[] array){
        for(int i=(array.length-1-1)/2;i>=0;i--){
            shiftDown(array,i,array.length-1);
        }
    }
    //向下调整(负责把每一颗子树调整为大根堆)(时间复杂度为log2^n)
    private void shiftDown(int[] array,int start,int end){
        int tmp=array[start];
        for(int i=2*start+1;i<=end;i=2*i+1){ //i<end 时说明它有左右孩子
            if((i<end)&&array[i]<array[i+1]){
                i++;   //i保存的是最大值的下标
            }
            if(array[i]>tmp){
                array[start]=array[i];
                start=i;
            }else{
                break;
            }
        }
        array[start]=tmp;
    }
    //快速排序
    void quickSort(int[] array){
        quick(array,0,array.length-1);
    }
    void quick(int[] array,int low,int high){
        if(low==high){
            return;
        }
        if(high-low+1<=10){
            insertSort1(array,low,high);
        }
        //takeThreeNumber(array,high,low);
        int par =partion(array,low,high);
        //递归左边
        if(par>low+1){  //为了保证此时左边有两个数据以上
            quick(array,low,par-1);
        }
        //递归右边
        if(par+1<high){   //为了保证此时右边有两个数据以上
            quick(array,par+1,high);
        }
    }
    //快速排序优化方式1：三数取中法:预防给的数据本来是有序的,可以减少栈溢出的概率，效率也会提很多
    void takeThreeNumber(int[] array,int low,int high){
        int mid=(low+high)>>>1;  //这里是无符号数右移一位
        if(array[mid]>array[low]){
            swap(array,mid,low);
        }
        if(array[mid]>array[high]){
            swap(array,mid,high);
        }
        if(array[low]>array[high]){
            swap(array,low,high);
        }
        //这三个if下来就可以达到array[mid]<=array[low]<=array[high],然后再用partion
    }
    //快速排序优化方式2：在low和high之间的数据低于一个数值时，做直接插入排序
    void insertSort1(int[] array,int low,int high){
        for (int i = low+1; i <high+1; i++) {
            int tmp = array[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }
    //快速排序原理1(Hoare法)
    int partion(int[] array,int low,int high){
        int i=low;
        int j=high;
        int par=array[low];
            while(i<j&&array[j]>par){
                j--;
            }
            while(i<j){
                while(i<j&&array[i]<par){
                    i++;
                }
            swap(array,i,j);
        }
        swap(array,i,low);
        return i;
    }
    //快速排序原理2(挖坑法)
    int partion1(int[] array,int low,int high){
        int tmp=array[low];
        while(low<high){
            while((low<high)&&array[high]>=tmp){
                high--;
            }
            if(low==high){
                //array[low]=tmp;
                break;
            }else{
                array[low]=array[high];
            }
            while((low<high)&&array[low]<=tmp){
                low++;
            }
            if(low==high){
                //array[low]=tmp;
                break;
            }else{
                array[high]=array[low];
            }
        }
        array[low]=tmp;
        return low;
    }
    //快速排序原理3(前后遍历法)
    int partion2(int[] array,int low,int high){
        int j=low+1;
        int tmp=array[low];
        for(int i=low+1;i<=high;i++){
            if(array[i]<tmp){
                swap(array,i,j);
                j++;
            }
        }
        swap(array,j-1,low);
        return j-1;
    }
    //冒泡排序
    void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }
    //归并排序
    void mergeSort(int[] array){
        mergeSortInter(array,0,array.length);
    }
    void mergeSortInter(int[] array,int low,int high){
        if(low+1>=high){
            return;
        }
        int mid=(low+high)/2;
        mergeSortInter(array,low,mid);
        mergeSortInter(array,mid,high);
        merge(array,low,mid,high);
    }
    //归并排序原理
    /* void merge1(int[] array,int low,int mid,int high){
        int[] extra=new int[high-low];
        int k=0;
        while(low<mid&&mid<high){
            if(array[low]<=array[mid]){//加入了等于，为了保证稳定性
                extra[k++]=array[low++];
            }else{
                extra[k++]=array[mid++];
            }
        }
       while(low<mid){
           extra[k++]=array[low++];
        }
        while(mid<high){
            extra[k++]=array[mid++];
        }
        for(int t=0;t<high-low;t++){
            array[low+t]=extra[t];
        }
    }*/
    /**
     上边的merge1方法是错误的，和下边唯一的区别是下边用了i,j来代替low,high，上边错误的原因是中间low和high 会发生变化导致错误
     */
    void merge(int[] array,int low,int mid,int high){
        int[] extra=new int[high-low];
        int k=0;int i=low;int j=mid;
        while(i<mid&&j<high){
            if(array[i]<=array[j]){  //加入了等于，为了保证稳定性
                extra[k++]=array[i++];
            }else{
                extra[k++]=array[j++];
            }
        }
        while(i<mid){
            extra[k++]=array[i++];
        }
        while(j<high){
            extra[k++]=array[j++];
        }
        for(int t=0;t<high-low;t++){
            array[low+t]=extra[t];
        }
    }

    //交换
    void swap(int[] array,int a,int b){
        int tmp=array[a];
        array[a]=array[b];
        array[b]=tmp;
    }
    //打印
    void show(int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
