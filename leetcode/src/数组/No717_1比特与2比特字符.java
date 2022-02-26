package 数组;

public class No717_1比特与2比特字符 {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length;) {
            if(bits[i] == 1){
                i += 2;
            }else{
                if(i == bits.length - 1) return true;
                i++;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        No717_1比特与2比特字符 v = new No717_1比特与2比特字符();
        int[] bits = {1, 1, 1, 0};

        boolean oneBitCharacter = v.isOneBitCharacter(bits);

        System.out.println(oneBitCharacter);
    }


    //执行用时：0 ms, 在所有 Java 提交中击败了 100.00%

}
