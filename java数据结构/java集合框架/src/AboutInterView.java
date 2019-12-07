import javafx.beans.binding.SetExpression;

import javax.xml.soap.Node;
import java.util.*;

public class AboutInterView {
    //1.只出现一次的数字，OJ链接：https://leetcode-cn.com/problems/single-number/
    public static int singleNumber1(int[] nums){
        //这里是为了了解Map的用法，实际上这种方法的效率不高
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            int c =map.getOrDefault(nums[i],0);
            map.put(nums[i],c+1);
           /*
           //也可以写成这种好理解一点
           Integer c=map.get(nums[i]);
            if(c==null){  //代表它是第一次出现
                map.put(nums[i],1);
            }else{
                map.put(nums[i],c+1);
        }*/
        }
        //这里用了foreach遍历法
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            int n=e.getKey();
            int c=e.getValue();
            if(c==1){
                return n;
            }
        }
        return -1;
    }
    public static int singleNumber2(int[] nums){
        //真正快速的算法：异或(两个数字进行异或相同为1，不同为0)
        int r=0;
        for(int n:nums){
            r=n^r;
        }  //这个算法执行下来就只剩r=1的数字了
        return r;
    }
    /*
    //2.复制带随机指针的链表,OJ链接：https://leetcode-cn.com/problems/copy-list-with-random-pointer/
    public Node copyRandomList(Node head) {

    }*/
    //3.宝石与石头,OJ链接：https://leetcode-cn.com/problems/jewels-and-stones/
    public int numJewelsInStones(String J, String S) {
        Set<Character> jewels=new TreeSet<>();
        //把所有的宝石先放进Set里边
        for(char j:J.toCharArray()){
            jewels.add(j);
        }
        //遍历所有的石头
        int count=0;
        for(char s:S.toCharArray()){
            if(jewels.contains(s)){
                count++;
            }
        }
        return count;
    }
    //3.坏键盘，牛客链接：https://www.nowcoder.com/questionTerminal/f88dafac00c8431fa363cd85a37c2d5e
    public static void BrokenKeyBoard(String J,String S){
        Scanner scanner=new Scanner(System.in);
        String right=scanner.nextLine();
        String wrong=scanner.nextLine();
        Set<Character> set=new TreeSet<>();
        //把坏的给装进Set中
        for(char c:wrong.toCharArray()){
            set.add(c);
        }
        Set<Character> written=new TreeSet<>();
        for(char d:right.toCharArray()){  //遍历好的
            if(!set.contains(d)){
                //d=Character.toUpperCase(d);  这个是转换大小写的函数（小写变大写）
                if(d>='a'&&d<='z'){
                    d+=('A'-'a'); //把筛选出来的都转换成大写（含有重复的）
                }
                if(!written.contains(d)){ //去重操作，这里是written篮子里边的东西与上边筛选出来的作比较
                    System.out.print(d);
                    written.add(d); //不包含的话就加入written的篮子
                }
            }
        }
    }
    //5.前K个高频单词，OJ链接：https://leetcode-cn.com/problems/top-k-frequent-words/description/
        //(1)先数出来每个单词出现的次数
    private static Map<String,Integer> calcount(String[] words) {
        Map<String,Integer> map=new HashMap<>();
        for(String s:words){
            int count=map.getOrDefault(s,0);
            map.put(s,count+1);
        }
        return map;
    }
        //(2)反转一下，统计每个出现次数下有哪些单词，并把他们放到一个List里
    private static Map<Integer,List<String>> calcountOfWords(Map<String,Integer> map) {
        Map<Integer,List<String>> ret=new HashMap<>();
        for(Map.Entry<String, Integer> e:map.entrySet()){
            String word=e.getKey();  //获取到某个单词
            int count=e.getValue();  //获取到他的出现次数
            if(!ret.containsKey(count)){
                ret.put(count,new ArrayList<>());  //不包含出现的次数的话先创建，例如1=[]
            }
            ret.get(count).add(word); //然后将这个单词添加到List中
        }
        return ret;
    }
        //传入一个比较器
    private static class IntegerComparator implements Comparator<Integer>{
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1; //这里输出的是逆序，如果是o1-o2是正序
            }
        }
    public static List<String> topKFrequent(String[] words, int k) {
        //假如这里传入的是["the", "day", "is", "sunny", "the", "the","the", "sunny", "is", "is"],k=3
        //输出的应该是["is", "the","sunny"]
        Map<String,Integer> wordCount=calcount(words);   //这里应该输出{the=4,is=3,sunny=2,day=1};
        Map<Integer,List<String>> countToWordList=calcountOfWords(wordCount);//这里应该输出{1=[day],2=[sunny],3=[is],4=[the]};
        Set<Integer> counts=countToWordList.keySet();  //得到[1,2,3,4]; 因为传下来的顺序很可能是乱的可能是[4,1,3,2]
        List<Integer> countsList=new ArrayList<>(counts);//转换成List形式
        Collections.sort(countsList,new IntegerComparator()); //得到[4,3,2,1]
        //Collections.sort(List<T> list, Comparator<? super T> c) 作用：根据指定的比较器引起的顺序对指定的列表进行排序
        List<String> result=new ArrayList<>();
        int n=0;
        for(int i=0;i<k;i++){
            int count=countsList.get(i);//countsList.get(i)是什么意思
            List<String> ws=countToWordList.get(count);//countToWordList.get(count)为什么这里能得到单词,第一次读取到的是the和is 两个单词
          // System.out.println(ws);
            Collections.sort(ws);
           if (ws.size() <= k -n) {  //为啥不是k
                // 如果候选人数量小于等于需要人数，全部录取
                result.addAll(ws);
                n += ws.size();  //感觉没必要写
            } else {
                // 否则，只录取需要的人数
                result.addAll(ws.subList(0, k - n)); //为啥不是K就行了
                n += (k - n); //为啥不是n++
            } /*
            if (ws.size() <= k ) {  //为啥不是k
                // 如果候选人数量小于等于需要人数，全部录取
                result.addAll(ws);
               // n += ws.size();  //感觉没必要写
            } else {
                // 否则，只录取需要的人数
                result.addAll(ws.subList(0, k-n)); //为啥不是K就行了
                n += (k - n); //为啥不是n++
            }*/
        }
        return result;
    }
    public static void main(String[] args) {
        //String[] words = {"the", "day", "is", "sunny", "is", "the", "the", "the", "sunny", "is", "is"};
        int k = 3;
        String[] words = {"i","love","leetcode","i","love","coding"};
        System.out.println(topKFrequent(words,k));
    }
}
