public class test9 {
        public static void main(String[] args) {
           String classFile = "com.jd.beijing". replace(".", "/") ;
           String classFile2 = "com.jd.beijing". replaceAll("\\.", "/");
           System.out.println(classFile);
           System.out.println(classFile2);
    }
}
