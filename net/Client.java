package com.net;

import sun.nio.cs.UTF_32;

import java.io.*;
import java.net.Socket;

/*
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        //1.创建客户端（套接字），连接指定的IP + 端口号
        Socket client = new Socket("127.0.0.1",6666);

        //2.获取输入输出流
        InputStream inputStream = client.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        OutputStream outputStream = client.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream,"UTF-8");
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        //3.发送数据
        printWriter.println("你好，我是客户端！");
        printWriter.flush();//刷新缓冲区

        //4.接收响应数据
        String message = bufferedReader.readLine();
        System.out.println("服务器客户端用户："+ message);

        //5.关闭流和客户端
        bufferedReader.close();
        printWriter.close();
        client.close();
    }
}
