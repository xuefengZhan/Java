package _17_反射._02_类加载器;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class _02_ClassLoader {
    @Test
    public void test() throws IOException {
        FileReader fr = new FileReader("jdbc.properties");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        System.out.println(s);
        br.close();
        fr.close();

        //报错：java.io.FileNotFoundException
        //原因：相对路径的根路径是项目目录，不是src目录
    }
    @Test
    public void test2() throws IOException {
        FileReader fr = new FileReader("src/jdbc.properties");
        BufferedReader br = new BufferedReader(fr);
        String s = br.readLine();
        System.out.println(s);
        br.close();
        fr.close();
        //username=root

        //src目录存放.java 源代码文件，部署的时候部署.class文件而不是.java文件
        //.class文件
    }

    @Test
    //src目录是类路径 classpath  和类在一起，用类加载器加载
    public void test3() throws IOException {
        Properties pro = new Properties();
        //todo 获取
        ClassLoader classLoader = _02_ClassLoader.class.getClassLoader();


        //todo src目录下的文件(source目录都可以直接写文件名)
       InputStream in = classLoader.getResourceAsStream("jdbc.properties");

        //todo src中 包下面的文件 加上包名
        //InputStream in = classLoader.getResourceAsStream("_17_反射/_02_类加载器/Demo.properties");

        //todo 项目目录下，src外部  不在类路径下了， 直接用FileInputStream了，而不是用类加载器了
        //InputStream in = new FileInputStream("out.properties");

        pro.load(in);
        System.out.println(pro);

        String username = pro.getProperty("username");
        System.out.println(username);


        //todo 类加载器加载的是项目下的source目录中的内容，只要是source Folder都可以直接写文件名
        //source目录编译之后都会在项目目录下的bin目录中
        //sourceFolder是源代码文件夹，一般会单独用一个config这种
        //sourceFolder来装配置文件，等价于src

    }

}
