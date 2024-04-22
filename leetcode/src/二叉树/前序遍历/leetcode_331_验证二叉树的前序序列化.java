package 二叉树.前序遍历;

import java.util.Objects;
import java.util.Stack;

/**
 * @ClassName leetcode_331_验证二叉树的前序序列化
 * @Author zxf
 * @Date 2023/12/25 9:06
 * @Questinon Describrition
 **/
public class leetcode_331_验证二叉树的前序序列化 {
    public boolean isValidSerialization(String preorder) {

        Stack<Character> stack = new Stack<>();
        boolean res = true;

        char[] chars = preorder.toCharArray();

        for (char node : chars) {
            if(node == ',') continue;
            res = add(stack,node);
            if(!res) break;
        }

        return stack.size() == 1 && stack.peek() == '#';
    }


    public boolean add(Stack<Character> stack, char node){
        if(node != '#'){
            stack.push(node);
        }else{
            if(!stack.isEmpty() &&  stack.peek() == '#'){
                stack.pop();
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                    add(stack,node);
                }
            }else{
                stack.push(node);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        leetcode_331_验证二叉树的前序序列化 v = new leetcode_331_验证二叉树的前序序列化();

        String s = "9,#,92,#,#";

        boolean res = v.isValidSerialization(s);

        System.out.println(res);
    }
}
