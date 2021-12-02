package _13_IO;

import org.junit.Test;

import java.io.*;

public class _06_try_catch {
    public static void main(String[] args) throws IOException {
        //从d:/scanner.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
        FileInputStream fis = new FileInputStream("d:/scanner.txt");
        InputStreamReader isr = new InputStreamReader(fis,"GBK");
        BufferedReader br = new BufferedReader(isr);

        FileOutputStream fos = new FileOutputStream("scanner.txt");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
        BufferedWriter bw = new BufferedWriter(osw);

        String str;
        while((str = br.readLine()) != null){
            bw.write(str);
            bw.newLine();
        }

        bw.close();
        osw.close();
        fos.close();

        br.close();
        isr.close();
        fis.close();

    }


    public void test01(){
        //从d:/scanner.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
        //第一步：声明并初始化要用到的资源为NUll
        FileInputStream fis = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        //第二步：将IO流对象的创建放在try块中
        try {
            fis = new FileInputStream("d:/scanner.txt");
            isr = new InputStreamReader(fis,"GBK");
            br = new BufferedReader(isr);

            fos = new FileOutputStream("scanner.txt");
            osw = new OutputStreamWriter(fos,"UTF-8");
            bw = new BufferedWriter(osw);

            String str;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{//第三步：将资源的关闭写在finally中
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(osw!=null){
                    osw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(isr!=null){
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fis!=null){
                    fis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    @Test
    // 减少流的关闭   关闭最外层会帮我们关闭内层流
    public void test02() {
        //从d:/scanner.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("d:/scanner.txt"),"GBK"));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("scanner.txt"),"UTF-8"));

            String str;
            while((str = br.readLine()) != null){
                bw.write(str);
                bw.newLine();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(bw!=null){
                    bw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    /*
     * JDK1.7中新增了一种try...catch处理的方式，
     * 此语法名称称为try...with....resource，但实际上代码中是没有with和resource，它是为资源关闭专门设计的try...catch的语法
     *
     *写法如下：
     * try(
     * 		需要关闭的资源对象的创建     写在try的小括号里面
     * ){
     * 		可能发生异常的逻辑代码
     * }catch(异常类型 e){
     * 		异常处理代码
     * }catch(异常类型 e){
     * 		异常处理代码
     * }
     *
     * 凡是在try()中声明的资源对象，都会自动关闭，无论是否发生异常。
     */

    public class TestTryWithResource {
        @Test
        public void test03() {
            //从d:/scanner.txt(GBK)文件中，读取内容，写到项目根目录下1.txt(UTF-8)文件中
            try (
                    FileInputStream fis = new FileInputStream("d:/scanner.txt");
                    InputStreamReader isr = new InputStreamReader(fis, "GBK");
                    BufferedReader br = new BufferedReader(isr);

                    FileOutputStream fos = new FileOutputStream("scanner.txt");
                    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                    BufferedWriter bw = new BufferedWriter(osw);
            ) {
                String str;
                while ((str = br.readLine()) != null) {
                    bw.write(str);
                    bw.newLine();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}