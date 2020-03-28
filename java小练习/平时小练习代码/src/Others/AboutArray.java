package Others;

public class AboutArray {
    public static void main(String[] args){
    double[][] m = {{1.5, 2, 3, 4}, {5.5, 6, 7, 8}, {9.5, 1, 3, 1}};
    double[][] n={{1,2,3,4.0},{5,6.5,7,8},{9,10,11,12},{13,14,15,16}};
    double[][] arr1={{1,2,3},{4,5,6},{7,8,9}};
    double[][] arr2={{0,2,4},{1,4.5,2.2},{1.1,4.3,5.2}};
    double[][] arr3=multiplyMatrix(arr1,arr2);
    //double sum = sumColumn(m);
    //double sum1=sunLine(m);
    //double sum2=sumMajorDiagonal(n);
   }
   //线性代数矩阵相乘
   public static double[][] multiplyMatrix(double[][] arr1,double[][]arr2){
        double x=0;
        double[][] extra=new double[arr2[0].length][arr1.length];
        for(int i=0;i<arr2[0].length;i++){
            for(int j=0;j<arr1.length;j++){
                extra[i][j]=arr1[i][0]*arr2[0][j]+arr1[i][1]*arr2[1][j]+arr1[i][2]*arr2[2][j];
            }
        }
        for(int m=0;m<arr2[0].length;m++){
            for(int n=0;n<arr1.length;n++){
                System.out.print(extra[m][n]+"  ");
            }
            System.out.println();
        }
        return extra;
   }
   //一个二维数组主对角线的和
    public static double sumMajorDiagonal(double[][] n) {
        double sum=0;int i=0;int j=0;
        while(i<n.length&&j<n.length){
           sum=sum+n[i][j];
           i++;j++;
        }
        System.out.println("它的对角线的和为："+sum);
        return sum;
    }
    //一个二维数组某一列的和
    public static double sumColumn(double[][] m){
        double sum=0;int i=0;
        for(int j=0;j<m[i].length;j++){
            for (;i < m.length; i++) {
                sum+=m[i][j];
            }
            System.out.println("第"+(j+1)+"列的和为："+sum);
            i=0;sum=0;
        }
        return sum;
    }
    //一个二维数组某一行的和
    public static double sunLine(double[][] m){
        double sum=0;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                sum+=m[i][j];
            }
            System.out.println("第"+(i+1)+"行的和为："+sum);
            sum=0;
        }
        return sum;
    }
}

