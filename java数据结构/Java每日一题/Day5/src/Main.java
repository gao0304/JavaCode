import java.util.ArrayList;
public class Main {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length < k){
            return list;
        }

        findKMin(input,0,input.length-1,k);
        for(int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }

    private void findKMin(int[] a, int start, int end, int k){
        if(start < end){
            int pos = partition(a, start, end);
            if(pos == k-1){
                return ;
            }else if(pos < k-1){
                findKMin(a,pos+1,end,k);
            }else{
                findKMin(a,start,pos-1,k);
            }
        }
    }

    public int partition(int[] a, int start, int end){
        int pivot = a[start];
        while(start < end){
            while(start < end && a[end] >= pivot){end--;};
            a[start] = a[end];
            while(start < end && a[start] <= pivot){start++;};
            a[end] = a[start];
        }
        a[start] = pivot;
        return start;
    }
}