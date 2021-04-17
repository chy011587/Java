package com.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务器端
 */
public class Server {
    public static void main(String[] args) throws IOException {
        //1.创建服务器端（套接字）
        ServerSocket server = new ServerSocket(6666);
        System.out.println("服务器已启动");

        //2.调用accept等待客户端
        Socket client = server.accept();

        //3.通过客户端获取输入输出流
        InputStream inputStream = client.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        OutputStream outputStream = client.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        PrintWriter printWriter = new PrintWriter(outputStreamWriter);

        //4.读取数据
        String message = bufferedReader.readLine();
        System.out.println("客户端用户："+ message);

        //6.关闭流、客户端和服务器端
        bufferedReader.close();
        printWriter.close();
        client.close();
        server.close();
    }
}
