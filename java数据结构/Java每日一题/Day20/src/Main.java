/**
 * [编程题]微信红包
 * 链接：https://www.nowcoder.com/questionTerminal/fbcf95ed620f42a88be24eb2cd57ec54?toCommentId=87162
 * 来源：牛客网
 *
 * 春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 *
 * 给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 *
 * 若没有金额超过总数的一半，返回0。
 * 测试样例：
 * [1,2,3,2,2],5
 * 返回：2
 */

import java.util.*;

public class Main {
    public int getValue(int[] gifts, int n) {
        // write code here
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            Integer count=map.get(gifts[i]);
            map.put(gifts[i],count==null?1:count+1);
        }
        int[] num=new int[n];
        int[] count=new int[n];
        int i=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            num[i]=entry.getKey();
            count[i]=entry.getValue();
            if(count[i]>n/2){
                return num[i];
            }
            i++;
        }
        return 0;
    }
}