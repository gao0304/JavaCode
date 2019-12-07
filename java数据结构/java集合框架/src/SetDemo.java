import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    public static void main(String[] args) {
        Set<String> bucket=new TreeSet<>();
        bucket.add("苹果");
        bucket.add("香蕉");
        bucket.add("梨");
        bucket.add("枣");
        bucket.add("橘子");
        System.out.println(bucket);
        System.out.println(bucket.size());
        System.out.println(bucket.contains("苹果"));
        bucket.remove("枣");
        System.out.println(bucket);
        bucket.add("苹果");
        System.out.println(bucket);
        bucket.clear();
        System.out.println(bucket);

    }
}
