package StringTable;

import org.junit.Test;

public class StringToString {
    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = s1.toString();
        String s3 = "abc";
        String s4 = s1.intern();

        System.out.println(s1==s2);//true
        System.out.println(s1==s3);//false
        System.out.println(s1==s4);//false

        System.out.println(s3==s4);//true


        char[] arr = {'e','d','c'};
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c);
        }
        String s = sb.toString();
        System.out.println(s.intern()); //etc
        System.out.println("edc");
    }
}
