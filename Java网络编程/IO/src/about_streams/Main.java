package about_streams;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File file=new File("测试目录\\测试文件.txt");
        file.createNewFile();
        /**
         * FileInputStream    源是文件内容
        OutputStream os=new FileOutputStream(file);
        os.write(97);
        os.write(98);
        os.write(99);
        os.write('a');
        byte[] buf="我是中国人".getBytes();
        //使用平台的默认字符集将此 String编码为字节序列，将结果存储到新的字节数组中。
        os.write(buf);
        */

        /**
        InputStream is=new FileInputStream(file);
        for(int i=0;i<19;i++){ //这里每次还要事先知道那个文件的大小，不方便
            int b=is.read();//当读到-1的时候说明已经读到了流的结尾处
            System.out.println(b);
        }
        //System.out.println(is.available());//这个可以显示这个文件的大小，但是只是一个估算值并不准确，不建议使用

        int b; //用这个方法更简单
        while((b=is.read())!=-1){
            System.out.println(b);
        }
        */
        /**
        //也可以用下边这个方法看出文件的大小
        byte[] buf1=new byte[1024]; //创建一个byte类型数组，意思一次最大读取1024个字节
        int len=is.read(buf1);//将buf1传进去，会返回最终实际上读取到的字节数
        System.out.println(len);
        String s=new String(buf1,0,len,"UTF-8");
        //通过使用平台的默认字符集解码指定的字节子阵列来构造新的String 。
        //新的String的长度是字符集的函数，因此可能不等于子数组的长度。
        System.out.println(s);
         */

        //ByteArrayInputStream  源是内存中的一段byte[]
        String s2="我是中国人";
        byte[] buf3=s2.getBytes("UTF-8");
        InputStream is1=new ByteArrayInputStream(buf3);
        int c;
        while((c=is1.read())!=-1){
            System.out.println(c);
        }
        System.out.println();
    }
}
