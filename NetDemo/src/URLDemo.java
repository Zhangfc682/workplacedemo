/**
 * @version: 0.1.0
 * @author: Zhangfucai
 * @Description:
 * @create: 2021-04-11 20:10
 * @Modified By:
 */

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName: URLDemo
 * @Description
 * URL:统一资源定位符。（Uniform Resource Locator）表示互联网上某一资源的地址。
 *
 * http://localhost:8080/examples/beauty.jpg?username=Tom
 * 协议    主机名    端口号  资源地址           参数列表
 *
 * @Author: Zhangfucai
 * @Date: 2021/4/11 20:10
 * @Version: 1.0
 */
public class URLDemo {
    public static void main(String[] args){
        try {
            URL url = new URL("https://localhost:8080/examples/beauty.jpg?usernam=Tom");

            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
