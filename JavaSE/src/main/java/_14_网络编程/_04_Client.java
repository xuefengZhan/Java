package _14_网络编程;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class _04_Client  {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 12321);

        InputStream in = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        OutputStream out = socket.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(out);
        BufferedWriter bw = new BufferedWriter(osw);
        PrintStream ps = new PrintStream(out);

        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("等待用户输入数据：");
            String s = scanner.next();


            // 发送给Server
            ps.println(s);
            System.out.println("客户端发出去的字符串为: " + s);


            if(s.equals("stop")){
                socket.shutdownOutput();
                break;
            }

            String s1 = br.readLine();
            System.out.println("服务器返回来的字符串为：" + s1);
        }

        socket.close();
        scanner.close();

    }
}
