package com.udp.threadUdpChat;

public class TestTalk {
    public static void main(String[] args) {
        new Thread(new TalkSend(7777,"localhost",9999)).start();
        new Thread(new TalkReceive(8888,"王平的妹妹")).start();
    }
}
