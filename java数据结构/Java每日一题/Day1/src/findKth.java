/**
 * [编程题]寻找第K大
 链接：https://www.nowcoder.com/questionTerminal/e016ad9b7f0b45048c58a9f27ba618bf
 来源：牛客网

 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。

 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。

 测试样例：
 [1,3,5,2,2],5,3
 返回：2
 */

class Find {
    public static int findKth(int[] a, int n, int K) {
        quick(a,0,n-1);
        return a[n-K];
    }
    public static void quick(int[] a,int low,int high){
        if(low==high){
            return;
        }
        int par=partion(a,low,high);
        //递归左边
        if(par>low+1){
            quick(a,low,par-1);
        }
        //递归右边
        if(par+1<high){
            quick(a,par+1,high);
        }
    }
    public static int partion(int[] a,int low,int high){
        int tmp=a[low];
        while(low<high){
            while((low<high)&&a[high]>=tmp){
                high--;
            }
            if(low==high){
                break;
            }else{
                a[low]=a[high];
            }
            while((low<high)&&a[low]<=tmp){
                low++;
            }
            if(low==high){
                break;
            }else{
                a[high]=a[low];
            }
        }
        a[low]=tmp;
        return low;
    }


    public static void main(String[] args) {
        int[] a={1,3,5,2,2};
        System.out.println(findKth(a, 5, 3));
           /* findKth(a, 6, 3);
            for(int i=0;i<a.length;i++){
                System.out.print(a[i]+" ");
            }*/
    }
}

