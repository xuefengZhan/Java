package _13_IO;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _04_scanner {
    @Test
    public void test01(){
        // 1.scanner是扫描器，从指定的输入流进行扫描

        // 2.in是inputStream类型
        // System.in 默认是从缉拿盘输入的数据中扫描
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
    }
    @Test
    public void test02() throws FileNotFoundException {
        //todo 2 从文本文件获取输入数据
        Scanner input = new Scanner(new FileInputStream("1.txt"));
        while(input.hasNextLine()){
            String s = input.nextLine();
            System.out.println(s);
        }
    }
}
