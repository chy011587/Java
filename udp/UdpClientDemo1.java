package com.udp;

import java.net.*;

public class UdpClientDemo1 {
    public static void main(String[] args) throws Exception {
        // 1.建立一个socket
        DatagramSocket socket = new DatagramSocket();

        // 2.建个包
        String msg = "你好，服务器！";
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9999;

        // 数据 数据启始长度  要发送给谁
        DatagramPacket packet  = new DatagramPacket(msg.getBytes(),0,msg.getBytes().length,localhost,port);

        // 3.发送包
        socket.send(packet);

        // 4.关闭流
        socket.close();
    }
}
