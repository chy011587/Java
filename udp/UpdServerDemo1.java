package com.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UpdServerDemo1 {
    public static void main(String[] args) throws SocketException {
        //开放端口
        DatagramSocket socket = new DatagramSocket(9999);

        //接收数据
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        try {
            socket.receive(packet);
            System.out.println(packet.getAddress().getHostAddress());
            System.out.println(new String(packet.getData(),0,packet.getLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //关闭流
        socket.close();


    }
}
