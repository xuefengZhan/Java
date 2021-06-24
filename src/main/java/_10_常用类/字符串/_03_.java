package _10_常用类.字符串;

import org.junit.Test;

public class _03_ {
    @Test
    public void test01(){
        String str = "HelloWorld RNG Win";
        char[] chars = str.toCharArray();
        int i = 0;
        for (int i1 = 0; i1 < chars.length; i1++) {
            if(chars[i1]>'A' && chars[i1]<'Z'){
                i++;
            }
        }
        System.out.println(i);
    }

}
