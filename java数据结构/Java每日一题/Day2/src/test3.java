import java.util.Scanner;

public class test3 {
    public static String replace(String s){
        String regEx="[\"`~!@#$^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）—+-|{}【】‘；：”“’。， 、？]";
        String aa="";
        String t=s.replaceAll(regEx,aa);
        return t;
    }
    public static boolean isPalindrome(String s) {
        String t=s.toLowerCase();
        char[] arr=t.toCharArray();
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s="0123456PQw";
        System.out.println(isPalindrome(replace(s)));
    }
}
