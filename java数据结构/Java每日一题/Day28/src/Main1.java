import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                //counter的作用是验证要求2：至少三种输入类型，每当密码中有一个类型时就+1
                int counter = 0;
                if (input.matches(".*\\d.*"))
                    counter++;
                if (input.matches(".*[a-z].*"))
                    counter++;
                if (input.matches(".*[A-Z].*"))
                    counter++;
                if (input.matches(".*[^a-zA-Z0-9].*"))
                    counter++;
                //&&之前是为了验证要求1和2，&&之后是为了验证要求3
                if (input.length() > 8 &&counter >= 3 && !input.matches(".*(...).*\\1.*"))
                    System.out.println("OK");
                else
                    System.out.println("NG");
            }
        }
    }
}