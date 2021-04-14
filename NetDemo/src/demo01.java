/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 14:55
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName: demo01
 * @Description
 * 1.通信双方地址：
 *  IP：网络中的主机地址，唯一地标识互联网上的计算机（InetAddress类表示IP地址对象）
 *  端口号：主机中的具体应用程序地址
 * 2.网络通信协议：
 *  OSI参考模型：模型过于理想化，未能在因特网上进行广泛推广。
 *  TCP/IP：国际标准
 * 3.域名：首先通过DNS服务器解析为IP地址，再进行查找访问
 * 4.本地回路地址：127.0.0.1 --> localhost
 *
 *  实例化IP地址：getByName(),getLocalHost()
 *  常用方法：getHostName(),getHostAddress()
 *
 *  端口号标识正在计算机上运行的进程。不同的进程有不同的端口号，为16位整数。
 *  端口号与IP地址的组合得出一个网络套接字：Socket
 *
 *  TCP：（传输控制协议）
 *  使用TCP协议前，须先建立TCP连接，形成传输数据通道。
 *  传输前，采用“三次握手”方式，点对点通信，是可靠的。
 *      三次握手：
 *          1.客户端发送syn报文，并置发送序号为X
 *          2.服务器发送syn+ACK报文，并置发送序号为Y，在确认序号为X+1
 *          3.客户端发送ACK报文，并置发送序号为Z，在确认序号为Y+1
 *  TCP协议进行通信的两个应用进程：客户端、服务端。
 *  在连接中可进行大数据量的传输。
 *  传输完毕，需释放已建立的连接，效率低。
 *
 *  UDP：（用户数据报协议）
 *  将数据、源、目的封装成数据包，不需要建立连接。
 *  每个数据报的大小限制在64k内。
 *  发送不管对方是否准备好，接收方收到也不确认，故是不可靠的。
 *  可以发送广播发送。
 *  发送数据结束时无需释放资源，开销小，速度快。
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 14:55
 * @Version: 1.0
 */
public class demo01 {
    public static void main(String[] args){
        try {
            InetAddress inetAddress = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress);

            System.out.println(inetAddress.getHostName()); //获取域名名称
            System.out.println(inetAddress.getHostAddress()); //获取IP地址

            InetAddress localHost = InetAddress.getLocalHost();  //本地地址
            System.out.println(localHost);

            System.out.println(InetAddress.getByName("localhost"));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void client(){

        Socket socket = null;  //指明服务器地址与端口号
        OutputStream os = null;  //数据输出流

        File file = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;

//        ByteArrayInputStream bais = null;

        try {
//            socket = new Socket("127.0.0.1",9888);
            socket = new Socket(InetAddress.getByName("127.0.0.1"),9888);
            os = socket.getOutputStream();

//            os.write("我是自定义客户端".getBytes());

            //客户端发送文件到服务器，应该先从本地读取文件，然后以字节格式发送到服务器
            file = new File("test.txt");
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);

//            bais = new ByteArrayInputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1){
                os.write(buffer,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void server(){
        ServerSocket serverSocket = null; //指明服务器端口号
        Socket accept = null;  //接受客户端socket对象
        InputStream is = null;  //数据接受流
        ByteArrayOutputStream baos = null;  //暂存容器

        File file = null;
        FileOutputStream fos = null;
        try {
            file = new File("test_accept.txt");

            serverSocket = new ServerSocket(9888);
            accept = serverSocket.accept();
            is = accept.getInputStream();
            fos = new FileOutputStream(file);

            baos = new ByteArrayOutputStream();  //用于在控制台输出显示

            byte[] buffer = new byte[20];  //读取数据的装载器 将读取到的数据存到文件中
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
                fos.write(buffer,0,len);
            }
            System.out.println(baos.toString());

            System.out.println("我是来自 " + accept.getInetAddress().getHostName() + " 的数据");
            System.out.println("我是来自 " + accept.getInetAddress().getHostAddress() + " 的数据");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (baos!=null){
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (accept!=null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
