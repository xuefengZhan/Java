package _14_网络编程;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class _03_Client {
    public static void main(String[] args) throws Exception {
        // todo 1、准备Socket，连接服务器，需要指定服务器的IP地址和端口号
        Socket socket = new Socket("127.0.0.1", 8888);

        // todo 2、获取输出流，用来发送数据给服务器
        OutputStream out = socket.getOutputStream();
        out.write("lalala".getBytes());

        //此方法会在输出流的末尾写入一个“流的末尾”标记，
        //这样对方的InputStream才能读到-1，否则对方的读取方法会一致阻塞
        //如果是out.close() 虽然看上去是关闭输出流，但是会导致整个Socket被关闭掉
        // 仅仅表示不发送消息了，但是还要接受消息，那么调用此方法表示关闭输出
        socket.shutdownOutput();



        //todo 3、获取输入流，用来接收服务器发送给该客户端的数据
        InputStream input = socket.getInputStream();
        // 接收数据
        byte[] data = new byte[1024];
        StringBuilder s = new StringBuilder();
        int len;
        while ((len = input.read(data)) != -1) {
            s.append(new String(data, 0, len));
        }
        System.out.println("服务器返回的消息是：" + s);

        //4、关闭socket，不再与服务器通信，即断开与服务器的连接
        //socket关闭，意味着InputStream和OutputStream也关闭了
        socket.close();
    }
}
