package _13_IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//案例：把用户的留言保存到message.txt文件中，从键盘输入留言
public class _05_输出纯文本文件 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File file1 = new File("测试用例/_13_IO");
        file1.mkdirs();
        File file = new File("测试用例/_13_IO/留言.txt");
        file.createNewFile();

        FileWriter fileWriter = new FileWriter("测试用例/_13_IO/留言.txt");

        while(scanner.hasNextLine()){
            String s = scanner.nextLine();
            if(s.equals("stop")){
                break;
            }
            fileWriter.write(s+"\n");
            fileWriter.flush();
        }
        fileWriter.close();
        scanner.close();
    }
}
