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

    @Test
    public void test02(){
        String url = "mongodb://10.20.0.70:27017::sc_audit::driverLocationUploadEntity::61272bc968ccf6000113760e";
        String[] split = url.split("::");
        for (String s : split) {
            System.out.println(s);
        }
    }

}
