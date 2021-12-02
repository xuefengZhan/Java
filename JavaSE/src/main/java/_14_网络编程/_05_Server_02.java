package _14_网络编程;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//todo  day23_16 TCP协议 服务器同时接收多个客户端同时发送单词翻转
public class _05_Server_02 {
    public static void main(String[] args) throws IOException {
        //1.开启服务器
        ServerSocket serverSocket = new ServerSocket(12321);
        System.out.println("服务器等待连接");


        //todo 方式2： 对于方式1来说，只能实现单个客户端通信
        // 因此只能用多线程，一个线程一个客户端
        boolean flag = true;
        while(flag){
            //2.接收客户端的连接
            Socket socket = serverSocket.accept();

            //3.为每一个客户端
            MessageHandler mh = new MessageHandler();
            mh.start();
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



            while((s=br.readLine()) != null){
                if("stop".equals(s)){
                    break;
                }


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

                ps.println(s1);
                System.out.println("翻转完毕为：" + s1);

            }
            System.out.println(3);
            System.out.println("客户端发来stop 停止服务器");

            //只有一个socket断开连接，server才能连接下一个。
            socket.close();
        }



        serverSocket.close();



    }

}

class MessageHandler extends Thread{
    @Override
    public void run() {
        super.run();
    }
}
