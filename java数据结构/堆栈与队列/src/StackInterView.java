import java.util.ArrayList;
class interView{
//括号匹配问题
/*
遍历字符串的每个字符
    如果是左括号：入栈  ***记得用break返回
    如果是右括号：
               如果栈是空的：不匹配（说明右括号多了）
               不为空：出栈
                      如果左右不匹配：不匹配；如果左右匹配：一直循环
                  循环完毕时，如果栈不为空，则不匹配（说明左括号多了）；否则匹配

 */
    public boolean isValid(String s){
        ArrayList<Character>stack=new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            switch(c){
                case'(':
                case'[':
                case'{':
                    stack.add(c);
                    break;
                case')' :
                case']' :
                case'}' : {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        char left = stack.remove(stack.size()-1);
                        if (!((left == '(' && c == ')')
                                || (left == '[' && c == ']')
                                || (left == '{' && c == '}'))) {

                            return false;
                        }
                        break;
                    }
                }
                default:break;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
public class StackInterView {
    public static void main(String[] args) {

    }
}
