import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
        int n=sc.nextInt(); //输入总共有多少门课程
        int[] gradeCredit=new int[n];//存储每门课学分的数组
        int[] grade=new int[n];//存储每门课分数的数组

        for(int i=0;i<n;i++){
            gradeCredit[i]=sc.nextInt(); //读入输入的第二行
        }
        for(int i=0;i<n;i++){
            grade[i]=sc.nextInt();//读入输入的第三行
        }
        System.out.printf("%.2f",averageCredit(gradeCredit,grade));
    }
}
    public static double averageCredit(int[] gradeCredit,int[] grade){
        double sum=0.0;//表示所有课程加起来应得的学分和
        double allClassCredit=0.0; //表示该学生能实际得到的学分绩点
        for(int i=0;i<grade.length;i++){
            allClassCredit+=gradeCredit[i]*GPA(grade[i]);
            sum+=gradeCredit[i];
        }
        return allClassCredit/sum;
    }
    //求每门课的成绩对应的学分绩点
    public static double GPA(int grade){
        double gpa = 0.0;
        if(grade>=90&&grade<=100)
            gpa=4.0;

        if(grade>=85&&grade<=89)
            gpa=3.7;

        if(grade>=82&&grade<=84)
            gpa=3.3;

        if(grade>=78&&grade<=81)
            gpa=3.0;

        if(grade>=75&&grade<=77)
            gpa=2.7;

        if(grade>=72&&grade<=74)
            gpa=2.3;

        if(grade>=68&&grade<=71)
            gpa=2.0;

        if(grade>=64&&grade<=67)
            gpa=1.5;

        if(grade>=60&&grade<=63)
            gpa=1.0;

        if(grade<60)
            gpa=0.0;

        return gpa;
    }
}
