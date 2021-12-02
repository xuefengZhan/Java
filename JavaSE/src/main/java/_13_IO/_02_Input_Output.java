package _13_IO;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class _02_Input_Output {
    @Test
    public void test01() throws IOException {
        FileInputStream fs = new FileInputStream("a.txt");
        FileOutputStream fo = new FileOutputStream("b.txt");
        int num;
        while((num = fs.read()) != -1){
            fo.write(num);
        }
    }

    @Test
    public void test02() throws IOException {
        FileInputStream fs = new FileInputStream("a.txt");
        FileOutputStream fo = new FileOutputStream("b.txt");
        byte[] b = new byte[10];
        int num;
        while((num = fs.read(b)) != -1){
            fo.write(b,0,num);
        }
    }
}
