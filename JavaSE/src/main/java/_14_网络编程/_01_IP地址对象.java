package _14_网络编程;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class _01_IP地址对象 {


    //todo 01 创建IP地址对象的三种方式：
    // IP地址的类型为：InetAddress
    @Test
    public void test01() throws UnknownHostException {

        //todo 1.本地IP InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();//主机名/IP地址
        System.out.println(localHost);

        //todo 1.通过域名获取InetAddress对象
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);

        //todo 2.通过IP地址获取InetAddress对象
        //ipv4 地址为32bit，4个无符号byte，有符号为-128到127，无符号为0-255
        byte[] addr = {(byte)192,(byte)168,30,(byte)142}; //超了，强转，按说会出问题，但是InetAddress作了处理
        InetAddress byAddress = InetAddress.getByAddress(addr);


    }
}
