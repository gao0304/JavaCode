//IO之输入流
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class IODemo {
    /**
     * 节点流
     * 1.可以从文件中读
     * 2.可以从网络中读（网卡/TCP连接）
     * 3.可以从内存中读（将内存中的一段空间当成输入源）
     * 4.可以从标准输入中读
     * @return
     */
    private static InputStream 获取一个输入流1() throws IOException {
        //节点流之方法1:可以从文件中读
        InputStream inputstream;
        inputstream=new FileInputStream("本地文件.txt");
        return inputstream;
    }
    private static InputStream 获取一个输入流2() throws IOException {
        //节点流之方法2：可以从网络中读（网卡/TCP连接）
        InputStream inputStream;
        Socket socket = new Socket("www.baidu.com", 80);
        OutputStream os = socket.getOutputStream();  //得到输出字节流
        Writer writer = new OutputStreamWriter(os, "UTF-8");//转换为输出字符流
        PrintWriter printWriter = new PrintWriter(writer, false);//转换为PrintWriter就可以正常的调用printf等方法（方便格式化输出）
        printWriter.printf("GET / HTTP/1.0\r\n\r\n");
        printWriter.flush();
        inputStream=socket.getInputStream();
        return inputStream;
        /**
         *
         public class PrintWriter extends Writer
         将对象的格式表示打印到文本输出流。 这个类实现了全部在发现print种方法PrintStream 。
         它不包含用于编写原始字节的方法，程序应使用未编码的字节流。
         不像PrintStream类，如果启用自动刷新，它只会在调用的println，printf，或format方法来完成，而不是当一个换行符恰好是输出。
         这些方法使用平台自己的行分隔符而不是换行符。
         */
    }
    private static InputStream 获取一个输入流3() throws IOException {
        ////节点流之方法3：可以从内存中读（将内存中的一段空间当成输入源）
        InputStream inputStream;
        byte[] bytes="我只是内存的一小段空间\r\n我是第二行\r\n".getBytes("UTF-8");
        inputStream=new ByteArrayInputStream(bytes);//创建一个 ByteArrayInputStream ，使其使用 buf作为其缓冲区数组。
        return inputStream;
    }
    private static InputStream 获取一个输入流4() throws IOException {
        ////节点流之方法4:可以从标准输入中读
        InputStream inputStream;
        inputStream=System.in;
        return inputStream;
    }

    /**
     * 处理流/过滤流（4种方法）
     * 1. 直接通过字节方式读，然后程序进行字符编码(buffer 大小 < 数据长度/精确控制字符都比较麻烦)
     * 2. 把 Stream 转化为 Reader，进行字符形式读取
     *      2.1 直接读
     *      2.2 BufferedReader      readLine
     * 3. Scanner 也可以
     */
    private static String 从字节流中最终获得字符数据1(InputStream is) throws IOException {
        /*处理流之方法1:直接通过字节方式读，然后程序进行字符编码
        方法的缺点：
        1.当文件的大小大于Byte[]的大小时，得分批次去读取，而且每次读出来的得进行转码很不方便，代码会很复杂
        2.当文件中有很多行的时候我们想读前几行，这个时候得去找/r/n等字符，这里做精确控制字符比较麻烦
        */
        byte[] buffer =new byte[1024];//这里的buffer是字节buffer
        int len =is.read(buffer);
        //数据放在buffer[0,len]中
        String message=new String(buffer,0,len,"UTF-8");
        return message;
    }
    private static String 从字节流中最终获得字符数据2(InputStream is) throws IOException {
         /*
          处理流之方法2.把stream转化为Reader，进行字符形式读取
          处理流之方法2.1 直接读
          优点：如果buffer小于文件的大小，虽然也需要进行多次读取，但是它每次读取到的是字符，不会出现读取某一个字（假设是3个字节）读一半的情况
         */
        /*
        StringBuilder sb=new StringBuilder();
        Reader reader=new InputStreamReader(is,"UTF-8");
        char[] buffer=new char[1024];//这里的buffer是字符buffer
        //这里是有一个缓冲区的概念，这里带来的缺点是假如我先开始想用readerLine读取，后边想用字节方式读取，这里就行不通了，因为它早已经将读好的放到了缓冲区里
        int len;
        while((len= reader.read(buffer))!=-1){
            sb.append(buffer,0,len);//这里不需要再转换了，因为char类型已经是字符级别码转化过的了
        }
        String message=sb.toString();
        return message;
        */
        /*
        处理流之方法2.2：通过BufferedReader进行读取，最重要的是它的readLine方法
         */
        Reader reader=new InputStreamReader(is,"UTF-8");
        BufferedReader bufferedReader=new BufferedReader(reader);//要用BufferedReader得要先创建Reader类型的变量
        String line;
        StringBuilder sb=new StringBuilder();
        while((line=bufferedReader.readLine())!=null){
            sb.append(line+"\r\n");//这里读取的时候是一行一行的读，它会默认的去掉/r/n，如果为了美观我们得手动去加
        }
        return sb.toString();
    }
    private static String 从字节流中最终获得字符数据3(InputStream is) throws IOException {
        //处理流之方法3.通过Scanner
        Scanner scanner=new Scanner(is,"UTF-8");
        StringBuilder sb=new StringBuilder();
        while(scanner.hasNextLine()){
           sb.append(scanner.nextLine()+"\r\n");//这里读取的时候是一行一行的读，它会默认的去掉/r/n，如果为了美观我们得手动去加
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
        InputStream is=获取一个输入流2();
        String message=从字节流中最终获得字符数据3(is);
        System.out.println(message);
    }
}
