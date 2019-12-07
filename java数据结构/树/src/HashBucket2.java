import java.util.Objects;

/**
 * 哈希表的注意事项：
 * 关于自定义类型作为HashMap的key和HsahSet的element时
 *       要保证：1.覆写hashCode和equals方法
 *             2. if(p.equals(q)){
 *                  //p和q的hashCode一定要保证相同，覆写方法时通过idea自带的功能覆写即可
 *                   }
 * 反过来说如果p和q的hashCode相同时，不能保证他们两一定相等（有哈希冲突）
 */
//这里是用泛型写的hashBucket
class Person{
    String sn;//学号
    char sex;//男女

    public Person(String sn, char sex) {
        this.sn = sn;
        this.sex = sex;
    }
    //下边就是equals和hashCode的覆写
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return sex == person.sex && Objects.equals(sn, person.sn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sn, sex);
    }
}
public class HashBucket2<K,V> {
    private static class Node<K,V>{
        private K key;
        private V value;
        private Node<K,V> next=null;
    }
    private Node<K,V>[] array=(Node<K,V>[])new Node[8];
    private int size;

    public V get(K key){
        int hash=key.hashCode();//注意点：这个方法是转换用的，给定任意类型的key,都可以把它转换为int类型
        int index=hash%array.length;
        Node<K,V> head=array[index];
        for(Node<K,V> cur=head;cur!=null;cur=cur.next){
            if(key.equals(cur.key)){ //注意点：这里因为是泛型，要用equals来判断
                return cur.value;
            }
        }
        return null;
    }

}
