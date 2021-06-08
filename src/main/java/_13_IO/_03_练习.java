package _13_IO;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class _03_练习 {


    //案例：把用户的留言保存到message.txt文件中，从键盘输入留言
    public static void main(String[] args) {
        System.out.println("请留言：");
        Scanner scanner = new Scanner(System.in);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(System.getProperty("user.dir") + File.separator + "留言.txt");
            bufferedWriter = new BufferedWriter(fileWriter);

            while (true) {
                String s = scanner.nextLine();
                if (s.equals("stop")) break;
                bufferedWriter.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
        }
    }
}

