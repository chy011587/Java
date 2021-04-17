package com.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
    public static void main(String[] args) {
        try {
            //      127.0.0.1   查询本机ip
            InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");

            InetAddress inetAddress3 = InetAddress.getByName("localhost");

            InetAddress inetAddress4 = InetAddress.getLocalHost();
            System.out.println(inetAddress1);
            System.out.println(inetAddress3);
            System.out.println(inetAddress4);

            //      查询网站地址
            InetAddress inetAddress2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inetAddress2);

            //      常用方法
            //System.out.println(inetAddress2.getAddress());
            System.out.println(inetAddress2.getCanonicalHostName());//规范的名字
            System.out.println(inetAddress2.getHostAddress());//Ip
            System.out.println(inetAddress2.getHostName());//域名或电脑名
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
