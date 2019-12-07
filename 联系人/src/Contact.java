import javax.naming.NameNotFoundException;
import java.util.Map;
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
    public static void select(Map map){
        if(map.isEmpty()){
            System.out.println("通信录为空");
        }else{
            System.out.println(map);
        }
    }
}
