package _13_IO;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class _01_file {

    //todo 01.认识file类
    // File类是java.io包下的;
    // File类代表与平台无关的文件和目录;
    // File类能新建、删除、重命名文件和目录;
    // 在API中File的解释是文件和目录路径名的抽象表示形式，即File类是文件或目录的路径，而不是文件本身。
    //           因此File类不能直接访问文件内容本身，如果需要访问文件内容本身，则需要使用输入/输出流。
    // 对于File对象来说，输入和输出操作只能针对文件，目录（文件夹）是不可的。

    @Test
    //todo 02.路径名
    public void test01() throws IOException {
        File f1 = new File("C:\\Users\\Administrator\\Desktop\\电影.txt");
        System.out.println(f1.getName()); //最后一级名称

        System.out.println(f1.getPath()); //file对象的路径
        System.out.println(f1.getAbsolutePath());//file对象的绝对路径

        System.out.println(f1.getAbsoluteFile());//File对象所对应的绝对路径名所对应的File对象

        System.out.println(f1.getCanonicalPath());//file对象的规范路径名

        System.out.println(f1.getParent());//父目录

        System.out.println(f1.getParentFile());//父file对象

    }

    @Test
    //todo 03.获取file的常规信息
    // 这些方法没有抛出异常，如果file不存在，结果为默认值
    public void test03(){
        File f1 = new File("C:\\Users\\Administrator\\Desktop\\电影.txt");

        System.out.println(f1.exists());//file对象是否存在

        System.out.println(f1.canRead());//可读？
        System.out.println(f1.canWrite());
        System.out.println(f1.canExecute());

        System.out.println(f1.isHidden());
        System.out.println(f1.isDirectory());
        System.out.println(f1.isFile());


        System.out.println(f1.length());

        System.out.println(f1.lastModified());


    }

    @Test
    //todo 4.操作文件
    public void test04() throws IOException {
        // 4.1创建文件  createNewFile()  如果文件已经存在，返回false
        File file = new File("testFile.txt");
        file.createNewFile();


        // 4.2 删除文件
        File file1 = new File("testFile.txt");
        file1.delete();

        file1.deleteOnExit();//当退出JVM时，删除文件，一般用于删除临时文件


        // 4.3 重命名文件
        // boolean renameTo(File dest)
        File file2 = new File("D:/IO_test/helloIO");
        File file3 = new File("D:/IO_test/helloIO.java");
        file2.renameTo(file3);

    }
    @Test
    // todo 5. 操作目录
    //todo 5.1创建目录
    public void test05(){

        File dir = new File("d:/IO_test/iodir");
        dir.mkdir();//如果d:/IO_test不存在不会报错，只是没创建成功

        dir.mkdirs(); //级联创建目录； 如果父级目录不存在，会一并创建
    }

    @Test
    //todo 6.列出目录内容
    public void test06(){
        File file = new File("D:\\Git");

        //todo 6.1  public String[] list()列出当前目录的下级目录或文件的名称
        String[] fileList = file.list();
        for (String s : fileList) {
            System.out.println(s);
        }

        //todo 6.2 public File[] listFiles() 列出当前目录的下级的目录或文件对应的File对象
        File[] files = file.listFiles();
        for (File file1 : files) {
            System.out.println(file1);
        }


    }

    @Test
    //todo 7.递归 实现打印一个目录下所有file名称

    public void test07(){
        File file = new File("D:\\开发工具");
        listSubFiles(file);
    }
    public void listSubFiles(File dir){
        if(dir == null)  return;
        if(dir.isDirectory()){
            File[] files = dir.listFiles();
            for (File file : files) {
                listSubFiles(file);
            }
        }
        System.out.println(dir);
    }


    @Test
    //todo 8.列出一个目录的大小
    public void test08(){
        File file = new File("D:\\开发工具");
        System.out.println(dirSize(file));
    }
    public long dirSize(File dir){
        if(dir == null) return 0l;
        if(dir.isFile()) return dir.length();
        File[] files = dir.listFiles();
        int sum = 0;
        for (File file : files) {
            sum += dirSize(file);
        }
        return sum;
    }
}

