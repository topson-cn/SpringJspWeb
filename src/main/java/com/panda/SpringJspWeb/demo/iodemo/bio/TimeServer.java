package com.panda.SpringJspWeb.demo.iodemo.bio;

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
            Socket socket = null;
            // 通过无线循环来监听客户端的连接
            while (true){
                // 如果没有客户端的连接,服务端阻塞在accept操作上
                socket = server.accept();
                // 当有新的客户端连接时,使用TimeserverHandler创建一个新的
                // 客户端线程来处理这条Socket链路
                new Thread(new TimeserverHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
