package com.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//创建文件上传客户端
public class FileClient {
    public static void main(String[] args) throws Exception {
        //1.创建一个socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),8888);

        //2.创建一个输出流
        OutputStream os = socket.getOutputStream();

        //3.读取文件
        FileInputStream fis = new FileInputStream(new File("1.jpg"));

        //4.写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len=fis.read(buffer))!= -1){
            os.write(buffer,0,len);
        }

        //5.通知客户端，已经传输完毕
        socket.shutdownOutput();

        //6.确定服务器接收完毕，才能断开连接
        InputStream inputStream = socket.getInputStream();
        //String byte[]
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buffer2 = new byte[1024];
        int len2;
        while ((len2=fis.read(buffer2))!=-1){
            baos.write(buffer2,0,len2);
        }

        //6.关闭资源
        fis.close();
        os.close();
        socket.close();
    }
}
