package _13_IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class _05_FileXxputStream {
    //把用户的留言保存到message.txt文件中，从键盘输入留言
    public static void writeMessage(File file,String msg) throws IOException {
        if(file.exists() != true){
            file.createNewFile();
        }
        if(file.isFile() != true){
            throw new IOException("not file,can't write");
        }

        FileOutputStream fos = new FileOutputStream(file);
        byte[] bytes = msg.getBytes("utf-8");

        fos.write(bytes);
        fos.close();
    }

    public static void main(String[] args) {
        try{

            writeMessage(new File("E:/work/Java/test/IO/留言.txt"),"你说你想要逃");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
