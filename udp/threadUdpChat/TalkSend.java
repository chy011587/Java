package com.udp.threadUdpChat;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class TalkSend implements Runnable {
    DatagramSocket socket = null;
    BufferedReader reader = null;
    private int formPort;
    private String toIp;
    private int toPort;

    public TalkSend(int formPort, String toIp, int toPort) {
        this.formPort = formPort;
        this.toIp = toIp;
        this.toPort = toPort;
        try{
            socket = new DatagramSocket(formPort);
            reader = new BufferedReader(new InputStreamReader(System.in));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        try{
            while (true) {
                String data = reader.readLine();
                byte[] datas = data.getBytes();//转为字节才可读
                DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.toIp, this.toPort));

                socket.send(packet);
                if (data.equals("bye")) {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        socket.close();
    }
}
