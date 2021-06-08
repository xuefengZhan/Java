package _13_IO;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class _04_scanner {

    public static void main(String[] args) {

//        //todo 案例1.next()和hasNext()
//        // 1.scanner是扫描器，从指定的输入流进行扫描
//        // 2.in是inputStream类型
//        // System.in 默认是从缉拿盘输入的数据中扫描
//        Scanner scan = new Scanner(System.in);
//
//
//        System.out.println("next方式接收：");
//        //判断是否有输入
//        while(scan.hasNext()) {
//            // next方式接收字符串
//            String str1 = scan.next();
//            System.out.println("输入的数据为：" + str1);
//        }
//        scan.close();
//
//        //todo 测试用例： 25 36
//        //     输出：   输入的数据为：25
//        //             输入的数据为：36
//        // while(scan.hasNext())会进入阻塞，一直等待输入
//        // 结论： next只能获取空格符以前的数据




//        //todo 案例2.nextLine()  hasNextLine()
//        Scanner scan = new Scanner(System.in);
//        // nextLine方式接收字符串
//        System.out.println("nextLine方式接收：");
//        // 判断是否还有输入
//        while(scan.hasNextLine()) {
//            String str2 = scan.nextLine();
//            System.out.println("输入的数据为：" + str2);
//        }
//        scan.close();
//        //todo 测试用例：25 36 72
//        //     输出：   输入的数据为：25 36 72
//        //while(scan.hasNextLine()) 会进入阻塞，一直等待输入
//        //nextLine()输出一行的数据，以换行符为分隔符


        //todo 案例3. 从文件扫描数据
        Scanner input = null;
        try {
            input = new Scanner(new FileInputStream("scanner.txt"));
            while(input.hasNextLine()){
                String s = input.nextLine();
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }



}
