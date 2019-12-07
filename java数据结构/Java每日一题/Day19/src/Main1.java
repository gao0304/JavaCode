/**
 * [编程题]子串判断
 * 链接：https://www.nowcoder.com/questionTerminal/917a800d4de1423394827932f4725c68?pos=81&mutiTagIds=579&orderByHotValue=0&questionTypes=000100&toCommentId=5030006
 * 来源：牛客网
 *
 * 现有一个小写英文字母组成的字符串s和一个包含较短小写英文字符串的数组p，请设计一个高效算法，对于p中的每一个较短字符串，判断其是否为s的子串。
 *
 * 给定一个string数组p和它的大小n，同时给定string s，为母串，请返回一个bool数组，每个元素代表p中的对应字符串是否为s的子串。保证p中的串长度小于等于8，且p中的串的个数小于等于500，同时保证s的长度小于等于1000。
 *
 * 测试样例：
 * ["a","b","c","d"],4,"abc"
 * 返回：[true,true,true,false]
 */
//主函数就不写了
public class Main1 {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] arr=new boolean[n];
        /**这里这么判断行倒是行，但是是O(n^2)复杂度呀
        for(int x=0;x<arr.length;x++){
            for(int i=0;i<p.length;){
                if(s.contains(p[i])){
                    arr[x]=true;
                }else {
                    arr[x]=false;
                }
            }
        }*/
        //因为s.contains本来返回的就是Boolean类型的值，所以直接赋值
        //这里的因为这里的p.length==n，所以就不用放在新的for循环里
        for (int i = 0; i < n; i++) {
            arr[i] = s.contains(p[i]);
        }
        return arr;
    }
}
