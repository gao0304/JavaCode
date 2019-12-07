import java.util.Arrays;

public class MyString2 {
    private char[] value;

    public MyString2(char[] value) {
        this.value = value;
    }
    public char[] toCharArray() {
        return Arrays.copyOf(value, value.length);
    }

    @Override
    public String toString() {
        return "value=" + Arrays.toString(value);
    }

    //equals方法
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyString)) return false;
        MyString2 myString = (MyString2) o;
        return Arrays.equals(value, myString.value);
    }
    //字符串转换成大写（考虑了不可变性：不改变原有的字符串）
    public MyString2 toUpperCase() {
        char[] value=toCharArray();
        for(int i=0;i<value.length;i++){
            if(Character.isLowerCase(value[i])){
                value[i] = Character.toUpperCase(value[i]);
            }
        }
        return new MyString2(value);
    }
    //忽略大小写判断字符串是否相等
    public boolean equalsIgnoreCase2(MyString2 o){
        if(o==null){
            return false;
        }
        if(value.length!=o.value.length){
            return false;
        }
        for(int i=0;i<value.length;i++){
            char c=Character.toUpperCase(value[i]);
            char d=Character.toUpperCase(o.value[i]);
            if(c!=d){
                return false;
            }
        }
        return true;
    }
    //字符串连接
    public MyString2 concat(MyString2 o){
        char[] v=new char[value.length+o.value.length];
        System.arraycopy(value,0,v,0,value.length);
        System.arraycopy(o.value,0,v,value.length,o.value.length);
        return new MyString2(v);
    }
    public static void main(String[] args) {
        char[] array={'a','b','c'};
        MyString2 str= new MyString2(array);
        char[] array2={'a','b','C'};
        MyString2 str2= new MyString2(array2);
        System.out.println(str.equals(str2));   //false
        System.out.println(str.toUpperCase());  //value=[A, B, C]
        System.out.println(str.equalsIgnoreCase2(str2));//true
        System.out.println(str.concat(str2));//value=[a, b, c, a, b, C]
    }
}
