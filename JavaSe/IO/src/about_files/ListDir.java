package about_files;//写一个函数：输出它目录下的所有文件
import java.io.File;
public class ListDir {
    //但是这个函数还有一点没有完善：就是电脑上的有些文件无权限访问造成空指针异常错误
    public static void listDir(File dir){
        File[] files=dir.listFiles();
        for(File file:files){
            if(file.isDirectory()){ //如果这个文件是文件夹那么继续递归（深度遍历）
                listDir(file);
            }else{
                System.out.println(file.getAbsolutePath());//如果不是，输出它的绝对路径
            }
        }
    }

    public static void main(String[] args) {
        listDir(new File("D:\\My Code\\JavaSe"));
    }
}
