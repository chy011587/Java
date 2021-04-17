package com.udp.threadUdpChat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TalkReceive implements Runnable {
    DatagramSocket socket = null;
    private int port;
    private String msgForm;
    public TalkReceive(int port,String msgForm) {
        this.port = port;
        this.msgForm = msgForm;
        try {
            socket = new DatagramSocket(port);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        try {
            while (true){
                byte[] container = new byte[1024];
                DatagramPacket packet = new DatagramPacket(container,0,container.length);//阻塞式接收包裹
                socket.receive(packet);
                byte[] data = packet.getData();
                String receiveData = new String(data, 0, data.length);
                System.out.println(msgForm + ":" + receiveData);
                if (receiveData.equals("bye")){
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        socket.close();

    }
}
