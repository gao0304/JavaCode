package about_files;

import java.io.File;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws IOException {
        /*
        File file=new File("D:\\My Code\\JavaSe");
        //File file=new File("D:\\My Code","JavaSe");两种表示方法
        System.out.println(file.exists());//判断这个文件是否存在
        System.out.println(file.isDirectory());//判断这个文件是不是目录
        System.out.println(file.getFreeSpace());//获取这个文件所在盘的可用空间大小
        System.out.println(file.getUsableSpace());//同上
        System.out.println(file.getTotalSpace());//获取这个文件所在盘的总共大小
        System.out.println(file.getAbsolutePath());//获取该文件的绝对路径(从盘符开始的路径)
        System.out.println(file.getParent());//获取它的上一级目录的绝对路径
        System.out.println(file.canRead());//判断该文件是否可读
        System.out.println(file.canWrite());//判断该文件是否可写
        System.out.println(file.canExecute());//判断该文件是否可执行
        System.out.println(file.isHidden());//判断该文件是否是隐藏文件
        System.out.println(file.length());//输出该文件的大小
        */
        /**
         *1）read：可读取文件的内容，例如读取文本文件的内容。
         *2）writer：可以编辑、新增或者修改文件的内容，但是不可以删除该文件。这里的修改都是基于文件内容的，文件中记录的数据而言的。
         *3）execute：该文件可以被系统执行。这个需要注意，因为Linux和Windows系统不一样。
         *  在Windows系统下，文件是否可以被执行是通过扩展名来区别的，例如.exe, .bat, .com等，这些文件类型都是可被执行的；
         *  而在Linux下，文件是否可以被执行时通过权限x来标注的，和文件名没有绝对的关系。
         */
        /*
        String parent="D:\\My Code\\JavaSe";
        File file1=new File(parent,"test.txt");//注意：这里不管这个父路径下有没有text.txt文件，都会创建一个对象
        file.createNewFile();//然后调用这个方法，就会创建出对应的文件
        file.delete();//删除这个文件（注意这里的删除操作不经过回收站）
        file.deleteOnExit();//这里也是删除操作，只不过这个操作在JVM退出后给删除掉
        file.mkdir();//创建一个文件夹
        File file2=new File(parent,"1\\2\\3\\test.txt");
        file.mkdirs();//这里也是创建目录，但是这里它会帮助我们去创建中间那些不存在的目录，比如我们一次要创建很多个文件夹
        */
        /*
        String path="D:\\My Code\\JavaSe";
        File file3=new File(path);
        File[] files=file3.listFiles(); //可以通过这个方法看出这个目录下下一级的所有文件
        for(File f:files){
            System.out.println(f.getAbsolutePath());
        }
        */
        String destPath1="D:\\My Code\\JavaSe\\新建文件夹";
        File file4=new File(destPath1);
        String destPath2="D:\\My Code\\JavaSe\\新建文件夹2";
        File file5=new File(destPath2);
        file4.renameTo(file5); //把destPath1文件名改为destPath2

        String path2="我的相对路径.txt";
        File file=new File(path2);
        file.createNewFile();
        /**
         * 注意：这里创建出来的我的相对路径.txt文件会出现在该项目的路径下
         * 这里为什么是这样呢：这里有一个相对路径的概念，相对的是程序此时的工作路径
         * 可以通过调用System.getProperty("user.dir")来看此时程序的工作路径
         */
    }
}
