/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 19:53
 * @Modified By:
 */

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @ClassName: UDPDemo
 * @Description
 * UDP网络编程
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 19:53
 * @Version: 1.0
 */
public class UDPDemo {
    @Test
    public void sender() throws IOException {
        //发送端
        DatagramSocket socket = new DatagramSocket();

        //封装数据报
        String str = "我是数据报";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,8999);

        //使用socket进行发送
        socket.send(packet);
        socket.close();
    }

    @Test
    public void receiver() throws IOException {
        //接受端
        //构建Socket对象
        DatagramSocket socket = new DatagramSocket(8999);

        //构建数据报
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        //接受数据
        socket.receive(packet);

        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();
    }
}
