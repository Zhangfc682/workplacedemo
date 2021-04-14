/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 18:15
 * @Modified By:
 */

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @ClassName: demo02
 * @Description
 * 从客户端发送文件给服务器，服务器保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。
 * @Author: Zhangfucai
 * @Date: 2021/4/11 18:15
 * @Version: 1.0
 */
public class demo02 {
    @Test
    public void client() throws IOException {
        //指定服务器的地址与端口号
        Socket socket = new Socket(InetAddress.getByName("localhost"),8998);

        OutputStream os = socket.getOutputStream();  //向服务器发送数据的输出流
        InputStream is = socket.getInputStream();  //接收服务器传送的数据

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        FileInputStream fis = new FileInputStream(new File("test.txt"));  //本地文件输入流
        BufferedInputStream bis = new BufferedInputStream(fis);

        byte[] buffer = new byte[1024];
        int len;
        while ((len = bis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        socket.shutdownOutput(); //关闭数据输出,必须要求这一步

        byte[] buffer1 = new byte[1024];
        int len1;
        String str = null;
        while ((len1 = is.read(buffer1)) != -1){
//            baos.write(buffer1,0,len1);
            str = new String(buffer1,0,len1);
        }
        System.out.println(str);
//        System.out.println(baos.toString());

        is.close();
        bis.close();
        fis.close();
        os.close();
        baos.close();
    }

    @Test
    public void server() throws IOException {

        //指定端口
        ServerSocket serverSocket = new ServerSocket(8998);
        //接受客户端套接字
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();  //从客户端获得输入流
        OutputStream os = socket.getOutputStream();//发送数据到客户端的输出流

        //数据接受与发送流
//        FileInputStream fis = new FileInputStream(new File("test_copy.txt"));
        FileOutputStream fos = new FileOutputStream(new File("test_copy.txt"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        os.write("发送成功".getBytes());

        os.close();
        fos.close();
        is.close();
        socket.close();

    }
}
