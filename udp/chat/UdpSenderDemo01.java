package com.udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpSenderDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);


        //准备数据：从控制台读取 system.in

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String data = reader.readLine();
            byte[] datas = data.getBytes();//转为字节才可读
            DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));

            socket.send(packet);
            if (data.equals("bye")) {
                break;
            }
        }
        socket.close();
    }
}
