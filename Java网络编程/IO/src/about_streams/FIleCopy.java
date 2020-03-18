//简单的实现一个文件拷贝功能
package about_streams;

import java.io.*;

public class FIleCopy {
    public static void main(String[] args) throws IOException {
        String src="D:\\My Code\\JavaSe\\IO\\测试目录\\测试文件.txt";
        String dest="D:\\My Code\\JavaSe\\IO\\测试目录\\目标文件.txt";

        InputStream is=new FileInputStream(src);
        OutputStream os=new FileOutputStream(dest);
        int b;
        while((b=is.read())!=-1){ //不断地进行读写
            os.write(b);
        }
    }
}
