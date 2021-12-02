package _10_常用类.字符串.编码解码;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _01 {
    public static void main(String[] args) {
        String a = "POINT (114.503976 30.557023)";
        byte[] bytes = a.getBytes(StandardCharsets.ISO_8859_1);
        System.out.println(Arrays.toString(bytes));

        String s = new String(bytes, 0, bytes.length, StandardCharsets.US_ASCII);
        System.out.println(s);

    }
}
