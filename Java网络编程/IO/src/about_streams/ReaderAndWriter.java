package about_streams;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ReaderAndWriter {
    public static void main(String[] args) throws IOException {
        File file=new File("D:\\My Code\\JavaSe\\IO\\测试目录\\测试文件.txt");
        /**
         * 方式1
        Reader reader=new FileReader(file);
        int b;
        while((b=reader.read())!=-1){
            System.out.println(b);
        }
         */
        /**
        InputStream is = new FileInputStream(file);
        InputStreamReader isReader = new InputStreamReader(is, "GB18030");
        char[] buf = new char[10];
        int len = isReader.read(buf);
        System.out.println(Arrays.toString(buf));
         */
        /**
        //通过BufferedReader一层层的处理得到
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(file), "GB18030")
        );
        reader.readLine();
         */
        //方式2：用Scanner直接从文件中进行读取
        InputStream is=new FileInputStream(file);
        Scanner scanner=new Scanner(is);
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
    }
}
