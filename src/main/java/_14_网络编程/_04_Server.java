package _14_网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


//todo 实现 ： 服务器端将客户端发送过来的词语翻转发送回去
public class _04_Server {
    public static void main(String[] args) throws IOException {
        //1.开启服务器
        ServerSocket serverSocket = new ServerSocket(12321);
        System.out.println("服务器等待连接");
        //2.接收客户端的连接
        Socket socket = serverSocket.accept();
        System.out.println("客户端已经连接");

        //3.获取输入流  和  输出流
        InputStream in = socket.getInputStream();
        // 按行作为一次输入  Scanner nextLine()和BufferedReader readLine()有按行读取的功能
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        OutputStream out = socket.getOutputStream();
        // todo 按行写出的流   BufferedWriter newLine()   PrintStream println()
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
        PrintStream ps = new PrintStream(out);
        String s;


//        s=br.readLine();
//        System.out.println("客户端发过来的字符串为：" + s);

        while((s=br.readLine()) != null){
            if("stop".equals(s)){
                break;
            }

            System.out.println(2);
            System.out.println("客户端发过来的字符串为：" + s);

            // todo 翻转s
            char[] chars = s.toCharArray();
            int len = chars.length;
            for(int i = 0;i<= len/2;i++) {
                char tmp = chars[i];
                chars[i] = chars[len - 1 - i];
                chars[len - 1 - i] = tmp;
            }
            String s1 = new String(chars);

//            StringBuilder sb = new StringBuilder(s);
//            sb.reverse();
//
//            ps.println(sb.toString());
//            System.out.println("翻转完毕为：" + sb.toString());

            ps.println(s1);
            System.out.println("翻转完毕为：" + s1);

        }
        System.out.println(3);
        System.out.println("客户端发来stop 停止服务器");


        //todo 4.关闭连接
        socket.close();
        serverSocket.close();



    }
}
