package _13_IO;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class _02_IO流 {
    @Test
    public void test00(){
        //todo 1.IO四大基本父类
        // 字节输入输出流：InputStream,OutputStream
        // 字符输入输出流: Reader,Writer

    }
    @Test
    //todo 从文本文件读取数据
    public void test01() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\单词本.txt");
        //todo 第一步：选择IO流，如果读取文件就用File，纯文本就用Reader文本文件用字符流
        FileReader file1 = new FileReader(file);
        //todo 第二步:从流中读取数据
        int len;
       while(( len = file1.read()) != -1){
           System.out.println(len);
       }

        //todo 第三步：关闭流
        file1.close();

    }
    @Test
    //todo 从文本文件读取数据
    public void test02() throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\单词本.txt");
        //todo 第一步：选择IO流，如果读取文件就用File，纯文本就用Reader文本文件用字符流
        FileReader file1 = new FileReader(file);


        //todo 第二步:从流中读取数据
        char[] arr = new char[10];
        while(true){
            int len = file1.read(arr);
            if(len == -1){
                break;
            }
            //String 构造器指定 char[] 的范围
            String s = new String(arr,0,len);
            System.out.print(s);
        }

        //todo 第三步：关闭流
        file1.close();

    }
    @Test
    //todo 写一些数据到文本文件中
    public void test03() throws IOException {
        File f = new File("D:/write.txt");
        FileWriter fileWriter = new FileWriter(f);
        String s = "瘦小离家胖了回\n" +
                   "乡音无改肉成堆";

        fileWriter.write(s);

        fileWriter.close();

    }

    //todo Scanner:
    @Test
    public void test04(){
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();//todo   遇到空白符认为输入结束
        String s = scanner.nextLine();//todo  读取流中一行数据，行的定义是结尾为换行符，遇到换行符认为输入结束
        scanner.nextInt(); //todo 只会读取整数  如果有换行，换行符不会被读取，还在流中
        System.out.println(next);
    }
    @Test
    //copy 纯文本文件
    public void test05(){
        try{
            File src = new File("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt");
            String name = src.getName();
            copy(src, new File("D:\\"+name));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void copy(File src,File dest) throws IOException {
        FileReader fileReader = new FileReader(src);
        FileWriter fileWriter = new FileWriter(dest);

        char[] c = new char[100];
        int len;
        while((len = fileReader.read(c)) != -1){
            fileWriter.write(new String(c,0,len));
        }

        fileReader.close();
        fileWriter.close();

    }


    @Test
    //todo 拷贝非文本文件
    public void test06() throws IOException {
        copy_picture("C:\\Users\\Administrator\\Desktop\\Jay\\images.jpg",
                "D:\\jay.jpg");
    }

    public void copy_picture(String src,String dest) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dest);

        byte[] b = new byte[1000];
        int len;
        while((len = in.read(b)) != -1){
            out.write(b,0,len);
        }

        in.close();
        out.close();
    }


    @Test
    //todo 缓冲流
    // 缓冲流是包装流
    // BufferedReader  -->Reader
    // BufferedWriter  -->Writer
    // BufferedInputStream -->InputStream
    // BufferedOutputStream --> OutPutStream

    //缓冲流在内存中添加了缓冲区，比直接和磁盘交互效率高很多；
    // 默认大小为8192,具体单位是看是什么流，字符流就是字符，字节流就是字节
    public void test07() throws IOException {
        FileReader fr = new FileReader("C:\\Users\\Administrator\\Desktop\\新建文本文档.txt");
        BufferedReader br = new BufferedReader(fr);

        String str;
        //BufferedReader的readLine()读取一行数据，返回值为该行数据
        while((str = br.readLine()) != null){
            System.out.println(str);
        }

        br.close();
        fr.close();
    }

    //todo BufferedWriter 换行
    @Test
    public void test08() throws IOException {
        FileWriter  Writer = new FileWriter("");
        BufferedWriter bufferedWriter = new BufferedWriter(Writer);

        //todo 实现输出到文本中的数据换行有两种方式：
        // 1.自己写‘\n’,但是不同操作系统肯能不兼容
        // 2.BufferedReader提供了标准换行方法
        bufferedWriter.newLine();

    }

    //todo InputStreamReader:
    // 将字节输入流转为字符输入流的转换流，并且能够制定解码格式；
    // 使用场景：由于reader和writer默认都是Unicode编码解码，
    // 因此 当源文件不是Unicode编码，可以按照字节流读取 并用指定解码方式 解码
    // 这样就能获取自定义解码方式的Reader了！
    @Test
    public void test09() throws FileNotFoundException, UnsupportedEncodingException {
        FileInputStream fis = new FileInputStream("");//将文件转为字节流
        InputStreamReader isr = new InputStreamReader(fis, "GBK");//转为字符流

    }

    //todo OutputStreamWriter:将字节按照指定的编码方式转为字符流
    @Test
    public void test10() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\write.txt");
        String s = "敢问胖胖你是谁";
        //todo 写到GBK编码的文件中
        //方式1.将String 按照GBK编码方式 编码成byte数组再写到文件
        byte[] b = s.getBytes("GBK");
        fos.write(b);
//        fos.close();

        //方式2.转换为GBK编码的方式将gbk字符写入GBK文件
        String s2 = "胖胖是三胖";
        OutputStreamWriter gbk = new OutputStreamWriter(fos, "GBK");//GBK字符
        gbk.write(s2);

        gbk.close();
        fos.close();


        //todo 上述两种方式 要么写入GBK编码方式的字节数组
        //      要么转为GBK解码的字符写到文件中
    }

    //todo day22_17
    // DataInputStream/DataOutputStream
    // 专门用于读写Java基本数据类型
    String name = "巫师";
    int age = 300;
    char gender = '男';
    int energy = 5000;
    double price = 75.5;
    boolean relive = true;
    @Test
    public void test11() throws IOException {
        FileOutputStream fos = new FileOutputStream("D:\\Dataoutput.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        //todo 只有writeUTF是按照UTF-8写出的不会乱码，用文本文件打开可以看得出来
        // 基本数据类型只有通过Java读写能够 看得出内容，否则会乱码
        dos.writeUTF(name);
        dos.writeInt(age);
        dos.writeChar(gender);
        dos.writeInt(energy);
        dos.writeDouble(price);
        dos.writeBoolean(relive);

        dos.close();
        fos.close();
    }
    @Test
    public void test12() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("D:\\Dataoutput.txt"));

        //Java基本数据类型的byte数不一致，因此用DataInputStream可以直接解析
        String name = dis.readUTF();
        int age = dis.readInt();
        char gender = dis.readChar();
        int energy = dis.readInt();
        double price = dis.readDouble();
        boolean relive = dis.readBoolean();

        System.out.println(name+"," + age + "," + gender + "," + energy + "," + price + "," + relive);

        dis.close();
    }

    //todo day22_18对象的序列化和反序列化
    // DataInputStream和DataOutputStream用于读写java基本数据类型
    // ObjectOutputStream和ObjectInputStream用于读写Java对象


    @Test
    public void test13() throws IOException {
        User u  = new User("zxf",2,"矮","男");
        FileOutputStream fos = new FileOutputStream("D:\\object.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        //ObjectOutputStream比OutputStream多一个方法：writeObject


        oos.writeObject(u);
        //将对象通过IO写出，需要实现序列化接口
        oos.close();
        fos.close();

    }

    @Test
    public void test14() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("D:\\object.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Object o = ois.readObject(); //把字节流中的数据转为一个对象，读取过程中会创建对象
                                    // new对象的时候需要找对象的类型
        System.out.println(o);  //User{name='zxf', age=2}
        //将对象通过IO写出，需要实现序列化接口
        ois.close();
        fis.close();

    }

    //todo day23_02 序列化接口Externalizable
    @Test
    public void test15() throws IOException{
        phone p = new phone("苹果",1);
        FileOutputStream fos = new FileOutputStream("d://Externalizable.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(p);

        oos.close();
        fos.close();
    }
    @Test
    public void test16() throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("d://Externalizable.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        System.out.println(o);

        ois.close();
        fis.close();
    }

}


