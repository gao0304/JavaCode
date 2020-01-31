//模拟一个Session服务端
package v2;

import v2.business.User;

import java.io.*;
import java.util.UUID;

public class SessionServer {
    private static String dir="会话";

    public static String put(User user) throws IOException{
        //生成一个全世界唯一的随机数
        String sessionId= UUID.randomUUID().toString();
        String filename=dir+"//"+sessionId;
        OutputStream os=new FileOutputStream(filename);
        ObjectOutputStream oos=new ObjectOutputStream(os);//实现序列化输出
        oos.writeObject(user);
        os.close();
        return sessionId; //返回服务器和客户端一个SessionId
    }
    public static User get(String sessionId) throws IOException{
        String filename=dir+"//"+sessionId;
        InputStream is=new FileInputStream(filename);
        ObjectInputStream ois=new ObjectInputStream(is);
         User user=null;
         try{
             user=(User) ois.readObject();//从session服务器上读取用户信息
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
         is.close();
         return user;
    }
}
