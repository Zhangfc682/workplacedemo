/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 16:20
 * @Modified By:
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @ClassName: TCPDemo
 * @Description TODO
 * @Author: Zhangfucai
 * @Date: 2021/4/11 16:20
 * @Version: 1.0
 */
public class TCPDemo {
    @Test
    public void test1(){

        Socket socket = null;
        OutputStream os = null;
        //客户端
        try {
            //服务器地址
            InetAddress inet = InetAddress.getByName("localhost");

            //指明服务器地址与端口号
            socket = new Socket(inet,8899);

            os = socket.getOutputStream();
            os.write("我是客户端".getBytes());  //是以字节为数据传输单位的

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (os != null) {
                    os.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        //服务器端
        ServerSocket ss = null;  //服务器端的IP地址与端口号
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try{
            ss = new ServerSocket(8899);  //指明服务器端口号

            socket = ss.accept();

            is = socket.getInputStream();  //建立输入流

            baos = new ByteArrayOutputStream();  //存储读取数据的流
            byte[] buffer = new byte[10];
            int len;
            while ((len = is.read(buffer)) != -1){
                baos.write(buffer,0,len);
            }

            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ss!=null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
