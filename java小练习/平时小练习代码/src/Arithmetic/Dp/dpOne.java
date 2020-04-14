package Arithmetic.Dp;

//在一个数组arr中，找出一组不相邻的数字，使得最后的和最大。
public class dpOne {
    //递归写法
    public static int rec_opt(int[] arr,int i){
        if(i==0){
            return arr[0];
        }else if(i==1){
            return Math.max(arr[0],arr[1]);
        }else{
            int check=rec_opt(arr,i-2)+arr[i];
            int uncheck=rec_opt(arr, i-1);
            return Math.max(check,uncheck);
        }
    }
    //迭代写法
    public static int dp_opt(int[] arr){
        int[] opt=new int[arr.length];
        opt[0]=arr[0];
        opt[1]=Math.max(arr[0],arr[1]);
        for(int j=2;j<arr.length;j++){
            int check=opt[j-2]+arr[j];
            int uncheck=opt[j-1];
            opt[j]=Math.max(check,uncheck);
        }
        return opt[opt.length-1];
    }
    public static void main(String[] args) {
        int[] arr={1,2,4,1,7,8,3};
        System.out.println(rec_opt(arr, arr.length - 1));
        System.out.println(dp_opt(arr));
    }
}
