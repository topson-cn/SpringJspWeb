package com.panda.SpringJspWeb.demo.iodemo.waiodemo;

import com.panda.SpringJspWeb.demo.iodemo.bio.TimeserverHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TimeServer {

    public static void main(String[] args) {
        // 默认监听端口
        int port = 8080;
        // 通过构造创建ServerSocket
        try (ServerSocket server = new ServerSocket(port)) {
            System.out.println("the time server is start in port:" + port);
            // 创建一个时间服务器处理类的线程池
            TimeServerHandlerExcutePool handlerExcutePool = new TimeServerHandlerExcutePool(50, 1000);
            Socket socket = null;
            // 通过无线循环来监听客户端的连接
            while (true){
                // 如果没有客户端的连接,服务端阻塞在accept操作上
                socket = server.accept();
                // 当有新的客户端连接时,将请求socket封装成Task交给线程池处理
                handlerExcutePool.execute(new TimeserverHandler(socket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
