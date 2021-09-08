package _10_常用类.字符串;

import java.util.Arrays;

public class test {
    public static void main(String[] args) {
        String s = "[\"1\",\"2\",\"3\"]";
        System.out.println(s);

        byte[] bytes = s.getBytes();
        int len = 0;
        for (byte aByte : bytes) {
            if(aByte<=57 && aByte>= 48){
               // System.out.println(aByte);
                len++;
            }

        }

        int i = 0;
        char[] result = new char[len];
        for (byte aByte : bytes) {
            if(aByte<=57 && aByte>= 48){
               result[i] = (char)aByte;
               i++;
            }
        }
        String s1 = new String(result);
        int i1 = Integer.parseInt(s1);
        System.out.println(s1);

    }
}
