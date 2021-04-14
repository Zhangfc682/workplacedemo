/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 18:59
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: test01
 * @Description
 * 服务器读取图片并发送给客户端，客户端保存图片到本地
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 18:59
 * @Version: 1.0
 */
public class test01 {
    @Test
    public void client() throws IOException {

        //与服务器建立连接并获取数据输入输出流
        Socket socket = new Socket(InetAddress.getByName("localhost"),8899);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        //建立客户端本地数据流
        FileOutputStream fos = new FileOutputStream(new File("client.jpeg"));
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        //接受服务器发送的数据
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            bos.write(buffer,0,len);
        }

        socket.shutdownInput();

        //接收完数据，给服务器发送一条数据，显示接收成功
        os.write("接受图片成功".getBytes());
//        socket.shutdownOutput();

        //关闭流
        bos.close();
        os.close();
        is.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {

        //搭建服务器端口与数据流
        ServerSocket serverSocket = new ServerSocket(8899);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        //读取服务器本地文件
        FileInputStream fis = new FileInputStream(new File("server.jpeg"));
        BufferedInputStream bis = new BufferedInputStream(fis);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1){
            //通过套接字输出流，发送给客户端
            os.write(buffer,0,len);
        }

        socket.shutdownOutput();
        System.out.println("数据发送完毕");

        //接受客户端返回的数据
        byte[] buffer1 = new byte[1024];
        int len1;
        String str = null;
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len1 = is.read(buffer1)) != -1){
//            baos.write(buffer1,0,len);
            str = new String(buffer1,0,len1);
        }

        System.out.println(str);
//        System.out.println(baos.toString());

        //关闭流
//        baos.close();
        bis.close();
        os.close();
        is.close();
        socket.close();
    }
}
