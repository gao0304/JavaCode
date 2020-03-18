import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.activation.DataSource;
import java.sql.*;

public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1. 注册 Driver
        Class.forName("com.mysql.jdbc.Driver");
        // 2. 通过 DriverManager 获取数据库连接
        // 加载JDBC驱动程序：反射，这样调用初始化com.mysql.jdbc.Driver类，即将该类加载到JVM方法区，并执行该类的静态方法块、静态属性
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://192.168.164.129:3306/mytest?useSSL=false",
                "root",
                "1"
        );
        //创建操作指令
        Statement statement=connection.createStatement();
        //执行SQl语句
        ResultSet resultSet=statement.executeQuery("select id,sn,name,qq_mail,classes_id from student");
        //处理结果集
        while(resultSet.next()){
            int id=resultSet.getInt("id");
            String sn=resultSet.getString("sn");
            String name=resultSet.getString("name");
            int classesId=resultSet.getInt("classes_id");
            System.out.println(String.format("student: id=%d,sn=%s,name=%s,classesId=%s",id,sn,name,classesId));
        }
        //释放资源
        //1.关闭结果集
        if(resultSet!=null){
            try{
                resultSet.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        //2.关闭命令
        if(statement!=null){
            try{
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        //3.关闭连接命令
        if(connection!=null){
            try{
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
