package _14_网络编程;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class _03_Server {

    public static void main(String[] args)throws Exception {

        //todo 1、准备一个ServerSocket对象，并绑定8888端口
        ServerSocket server = new ServerSocket(8888);
        System.out.println("等待连接");

        //todo 2、调用accept()方法，用于监听8888端口的客户端的连接
        // 该方法是个阻塞的方法，如果没有客户端连接，将一直等待
        Socket socket = server.accept();
        System.out.println("一个客户端连接成功！！");

        //todo 3、获取输入流，用来接收该客户端发送给服务器的数据
        InputStream input = socket.getInputStream();

        //接收数据
        byte[] data = new byte[1024];
        StringBuilder s = new StringBuilder();

        //todo 额外说明：
        // input.read(data)) == -1 的条件是输入流中没有下一个字节了
        // 但是TCP协议中，是大数据量传输，会认为是一直传输数据，就会导致
        // 永远无法等于-1,那么就一直在获取数据，跳不出循环。
        // 只有Client端的Socket的输出流关闭了，Server端的Input.read()才会等于-1

        int len;
        while ((len = input.read(data)) != -1) {
            s.append(new String(data, 0, len));
        }
        System.out.println("客户端发送过来的消息是：" + s);

        //todo 4、获取输出流，用来发送数据给该客户端
        OutputStream out = socket.getOutputStream();
        //发送数据
        out.write("欢迎登录".getBytes());
        out.flush();

        //todo 5、关闭socket，不再与该客户端通信
        //socket关闭，意味着InputStream和OutputStream也关闭了
        socket.close();

        //todo 6、如果不再接收任何客户端通信，可以关闭ServerSocket
        server.close();
    }
}