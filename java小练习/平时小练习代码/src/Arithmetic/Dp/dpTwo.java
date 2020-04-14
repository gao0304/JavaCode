package Arithmetic.Dp;

//给定一个正整数s, 判断一个数组arr中，是否有一组数字加起来等于s。
public class dpTwo {
    //递归写法
    public static boolean rec_subset(int[] arr,int i,int s){
        if(s==0){  //说明已经加够了
            return true;
        }else if(i==0){  //说明就剩最后一个数没加，如果恰好相等那么就符合题意
            return arr[0]==s;
        }else if(arr[i]>s){//当有一个数直接大于题上要求的数字，那么就没有选的必要
            return rec_subset(arr,i-1,s);//直接跳过这个数
        }else{
            boolean check=rec_subset(arr,i-1,s-arr[i]);
            boolean uncheck=rec_subset(arr,i-1,s);
            if(check||uncheck==true){
                return true;
            }
        }
        return false;
    }
    //迭代写法
    public static boolean dp_subset(int[] arr,int s){
        boolean[][] subset= new boolean[arr.length][s + 1];
        for(int i=0;i<s+1;i++){
            /*将第一行的元素全部置为false，等同于递归版本的i==0判断条件，
            但是有一个元素得是true，这个元素就是arr[0]对应的那个数，也就是subset[arr[0]]，
            因为这个元素对应的是恰好加上那个元素符合题意
            */
            subset[0][i]=false;
        }
        if(s>=arr[0]){  //这里要加个判断，不然很有可能会越界
            subset[0][arr[0]]=true;
        }
        //将第一列全部置为true需要放在初始化第一行的代码之后，否则会出错
        for(int i=0;i<arr.length;i++){
            //将第一列的元素全部置为true，等同于递归版本的s==0判断条件
            subset[i][0]=true;
        }
        for(int i=1;i<arr.length;i++){
            for(int j=1;j<s+1;j++){
                if(arr[i]>j){
                    subset[i][j]=subset[i-1][j];
                }else {
                    boolean check=subset[i-1][s-arr[i]];
                    boolean uncheck=subset[i-1][s];
                    subset[i][j]=check||uncheck;
                }
            }
        }
        return subset[arr.length-1][s];
    }
    public static void main(String[] args) {
        int[] arr={3,34,4,12,5,2};
        System.out.println(rec_subset(arr, arr.length - 1, 35));
        System.out.println(dp_subset(arr, 34));
    }
}

