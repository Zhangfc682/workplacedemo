/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 19:33
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

/**
 * @ClassName: test03
 * @Description
 * 客户端给服务器发送文本，服务器将文本转成大写返回客户端
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 19:33
 * @Version: 1.0
 */
public class test03 {
    @Test
    public void client() throws IOException {

        Socket socket = new Socket(InetAddress.getByName("localhost"),8889);
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        //向服务器发送数据
        os.write("abcdefs".getBytes());
        socket.shutdownOutput();
        System.out.println("客户端发送数据。。。");

        //接受服务器返回的数据
        byte[] buffer = new byte[1024];
        int len;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len = is.read(buffer)) != -1){
            baos.write(buffer,0,len);
        }
        System.out.println("客户端接受到：" + baos.toString());

        os.close();
        is.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {

        ServerSocket serverSocket = new ServerSocket(8889);
        Socket socket = serverSocket.accept();
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();

        //接受客户端数据
        byte[] buffer = new byte[1024];
        int len;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((len = is.read(buffer)) != -1){
            //写入容器中
            baos.write(buffer,0,len);
        }

        System.out.println("服务器接受数据完成，转换为大写。。。");
        String str = baos.toString().toUpperCase();

        //发送数据给客户端
        os.write(str.getBytes());
        System.out.println("服务器发送大写数据。。。");
        socket.shutdownOutput();

        baos.close();
        os.close();
        is.close();
        socket.close();

    }
}
