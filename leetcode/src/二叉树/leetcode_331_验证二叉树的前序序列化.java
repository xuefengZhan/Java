package 二叉树;

import java.util.Objects;

/**
 * @Date 2023/11/6 22:35
 * @Author 詹学丰
 * @Name leetcode_331_验证二叉树的前序序列化
 * @QUESTION DESCRIPTION
 * @TAG
 * @RESULT
 *
 * mid
 **/

public class leetcode_331_验证二叉树的前序序列化 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
    }

    int index = 0;
    private boolean dfs(String[] words){
        if(Objects.equals(words[index++], "#")){
            return true;
        }

        dfs(words);
    }
}
