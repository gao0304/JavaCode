import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    File file;
    long totalLength;//这里是指这个文件的大小（可能这个文件是文件夹），那么这里指的是它和它下级文件的总大小
    List<TreeNode> children=new ArrayList<>();
}
