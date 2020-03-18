//问题：输入任意数量的数字,统计每个数字出现的次数,求出最大值,并从大到小排序
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        // 用来统计每个数字出现的次数
        Map<Integer, Integer> map = new HashMap<>(); //第一步骤

        System.out.println("请输入任意个数字（输入-1结束）");
        Scanner scanner = new Scanner(System.in);
        int input;
        //第一步骤
        while ((input = scanner.nextInt()) != -1) {
            Integer count = map.get(input);
            map.put(input, count == null ? 1 : count + 1);
        }
        //第二步骤
        int size = map.size();
        int[] num = new int[size]; // 存储输入数字
        int[] count = new int[size]; // 存储对应数字的次数
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            num[i] = entry.getKey();
            count[i] = entry.getValue();
            i++;
        }
        // 根据出现次数排序
        for (int j = 0; j < size - 1; j++) {
            for (int k = j; k < size; k++) {
                if (count[j] < count[k]) {
                    int temp = count[j];
                    count[j] = count[k];
                    count[k] = temp;

                    // 数字数组也同步交换
                    temp = num[j];
                    num[j] = num[k];
                    num[k] = temp;
                }
            }
        }
        //第三步骤
        System.out.println("数字\t次数");
        for (int j = 0; j < size; j++) {
            System.out.println(num[j] + "\t" + count[j]);
        }
    }
}