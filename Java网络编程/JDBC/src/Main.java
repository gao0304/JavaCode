/**
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册 Driver
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 通过 DriverManager 获取数据库连接
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://192.168.164.129:3306/java11_1119?useSSL=false&serverTimezone=UTC",
                "root",
                "1"
        );
        System.out.println(connection);
        //最后关闭连接
        connection.close();
    }
}
*/