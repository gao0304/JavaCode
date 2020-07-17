import java.util.Scanner;

public class Main6{
    public static boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public static String longestPalindrome(String s){

        int len=s.length();
        if(len<2){
            return s;
        }
        int maxLen=1;
        String res=s.substring(0,1);
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(j-i-1>maxLen&&isPalindrome(s,i,j)){
                    maxLen=j-i+1;
                    res=s.substring(i,j+1);
                }
            }


        }return res;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String s=scanner.nextLine();
            System.out.println(longestPalindrome(s));
        }
    }
}