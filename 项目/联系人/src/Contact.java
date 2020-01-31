import javax.jws.soap.SOAPBinding;
import javax.naming.NameNotFoundException;
import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Contact {
    Map<String,User> map=new TreeMap();
    //添加
    public void add(String name,String mobilePhone,String officePhone) throws NameExistException{
        User user=new User(name, mobilePhone, officePhone);
        if(map.containsKey(name)){
            throw new NameExistException();
        }
        map.put(name,user);
    }
    //查找
    public User get(String name){
        return map.get(name);
    }
    //删除
    public void remove(String name) throws NameNotFoundException {
        if(!map.containsKey(name)){
            throw new NameNotFoundException();
        }
        map.remove(name);
    }
    public void showAll(Contact contact, Scanner scanner){
        for(Map.Entry<String,User> entry: map.entrySet()){
            System.out.println(entry.getKey()+"   "+entry.getValue().toString());
        }
    }
    //保存
    public void save() throws IOException {
        File file=new File("联系人目录.txt");
        FileWriter fileWriter=new FileWriter(file);
        for(Map.Entry<String,User> entry: map.entrySet()){
           String s=entry.getKey();
           for(int i=0;i<s.length();i++){
               fileWriter.append(s.charAt(i));
           }
            fileWriter.append("   手机号：");
           String s1=entry.getValue().mobilePhone;
           for(int i=0;i<s1.length();i++){
               fileWriter.append(s1.charAt(i));
           }
           fileWriter.append("  办公室电话：");
           String s2=entry.getValue().officePhone;
           for(int i=0;i<s2.length();i++){
               fileWriter.append(s2.charAt(i));
           }
            fileWriter.append("\r\n");
            fileWriter.flush();
        }
        fileWriter.close();
    }
    //读取
    public void read() throws IOException {
        File file=new File("D:\\My Code\\项目\\联系人\\联系人目录.txt");
        Scanner scanner =new Scanner(file);
        while(scanner.hasNextLine()){
            String s=scanner.nextLine();
            System.out.println(s);
        }
    }
}
