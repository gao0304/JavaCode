import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            String[] largeNum=new String[n];
            //输入
            for(int i=0;i<n;i++){
                largeNum[i]=sc.next();
            }
            //排序
            quickSort(largeNum,0,n-1);
            //输出
            for(int i=0;i<n;i++){
                System.out.println(largeNum[i]);
            }
        }
    }

    private static void quickSort(String[] data, int l, int h) {
        if(l<h){
            int i=l;
            int j=h;
            String key=data[i];
            while(i<j){
                while (i<j&&compare(key,data[j])<0){
                    j--;
                }
                if(i<j){
                    data[i++]=data[j];
                }

            }

        }
    }
    private static int compare(String key,String datum){
        // 长度越长的字符串所代表的数值越大
        if(key.length()>datum.length()){
            return 1;
        }else if(key.length()<datum.length()){
            return -1;
        }else {
            // 长度相同的字符串再从最高字符位到最低字符位逐字符比较
            return key.compareTo(datum);//使用String.compareTo方法可以用字典排序的方式比较两个字符串的大小
        }

    }
}
