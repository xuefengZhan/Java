package _13_IO;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class _03_打印流 {
    @Test
    public void test01() throws FileNotFoundException, UnsupportedEncodingException {
        //todo PrintStream 可以输出到文件
        //还可以指定编码格式
        PrintStream ps = new PrintStream("1.txt","GBK");
        ps.println("中文");
        ps.close();
    }

    @Test
    public void test02() throws FileNotFoundException, UnsupportedEncodingException {
        //todo PrintStream 可以输出到文件
        //还可以指定编码格式
        PrintStream ps = new PrintStream("1.txt");
        ps.println(new User("钩子",23,"高","男"));
        ps.close();

        //todo printStream打印对象到文件中的时候，对象变成一个json
        //User{name='钩子', age=23, height='高', sex='男'}
    }
}
