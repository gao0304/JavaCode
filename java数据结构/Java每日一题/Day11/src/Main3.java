/**
 * [编程题]构建乘积数组
 * 链接：https://www.nowcoder.com/questionTerminal/94a4d381a68b47b7a8bed86f2975db46
 * 来源：牛客网
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Main3 {
    public static void main(String[] args) {
        int[] A={1,2,3,4,5};
        multiply(A);
    }
    public static void multiply(int[] A) {
        int[] arr2 = new int[A.length];
        for(int i=0;i<arr2.length;i++){
            arr2[i]=1;
        }
        for (int i = 0; i < arr2.length; i++) {
            for (int j = A.length-1; j >0; ) {
                if(i==j){
                   j=j-1;
                }
                arr2[i]*=A[j];
                j--;
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
    }
}
