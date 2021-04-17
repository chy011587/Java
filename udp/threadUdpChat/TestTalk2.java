package com.udp.threadUdpChat;

public class TestTalk2 {
    public static void main(String[] args) {
        new Thread(new TalkSend(5555,"localhost",8888)).start();
        new Thread(new TalkReceive(9999,"王平")).start();
    }
}
