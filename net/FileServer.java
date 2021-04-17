package com.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//服务端接收文件
public class FileServer {
    public static void main(String[] args) throws Exception {
        //1.创建服务
        ServerSocket serverSocket = new ServerSocket(8888);

        //2.监听客户端连接
        Socket socket = serverSocket.accept();

        //3.获取输入流
        InputStream is = socket.getInputStream();

        //4.文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.jpg"));

        byte[] buffer = new byte[1024];
        int len;
        while ((len=is.read(buffer))!= -1){
            fos.write(buffer,0,len);
        }

        //5.通知客户端我接受完毕
        OutputStream os = socket.getOutputStream();
        os.write("我已经接收，可以断开连接".getBytes());

        //6.关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
