package _10_常用类.zifuchuan;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class _01_ {
    @Test
    public void test01() throws UnsupportedEncodingException {
        String s = "abcde.=325";
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));//[a, b, c, d, e, ., =, 3, 2, 5]


        Charset charset = Charset.defaultCharset();
        //编码 根据指定的字符集 编成2进制码数组   Unicode编码范围：0-65535
        byte[] bytes = "易".getBytes(charset);
        System.out.println(Arrays.toString(bytes)); //[-26, -104, -109]
        //解码
        System.out.println(new String(bytes, "utf-8"));//易

        Character a = '易';

        System.out.println('易');


    }
}
