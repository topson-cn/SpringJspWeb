package com.panda.SpringJspWeb.demo.iodemo.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class TimeClient {

    public static void main(String[] args) {
        int port = 8080;
        try (Socket socket = new Socket("127.0.0.1",port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            // 向服务端发送指令
            out.println("QUERY TIME ORDER");
            System.out.println("send order to server success");
            // 读取响应并打印
            String resp = in.readLine();
            System.out.println("Now is : " + resp);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
