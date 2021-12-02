package _13_IO;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class _03_Reader_Writer {
    @Test
    public void test01() throws IOException {

        FileReader fr = new FileReader("a.txt");
        FileWriter fw = new FileWriter("b.txt");

        int read;

        while((read=fr.read())!=-1){
            System.out.println(read);//read是Unicode编码值
            fw.write(read);
        }

        fw.write(97); //文件中是Unicode码的解码值
        fr.close();
        fw.close();

        //FileReader 将文件内容以Unicode字符集 进行编码写进内存中，内存中是Unicode码
        //FileWriter 将内存中Unicode码 进行解码 再写到目标文件中
        //
    }
}
