package com.panda.SpringJspWeb.demo.iodemo.bio;

import lombok.AllArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 〈一句话功能简述〉<br>
 *
 * @author 18048474
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@AllArgsConstructor
public class TimeserverHandler implements Runnable {

    private Socket socket;

    @Override
    public void run() {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String body = null;
            while (true){
                // 通过bufferReader读取一行
                body = in.readLine();
                // 如果已经读到输入流的尾部,则返回值为null,退出循环
                if (body == null){
                    break;
                }
                System.out.println("The time server receive order:" + body);
                // 读到非空值,对内容进行判断,如果请求是查询当前时间的指令QUERY TIME ORDER则获取当前时间
                String currentTime = "QUERY TIME ORDER".equals(body) ? String.valueOf(System.currentTimeMillis()) : "BAD ORDER";
                // 通过PrintWriter的print函数发送给客户端,最后退出循环
                out.print(currentTime);
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
