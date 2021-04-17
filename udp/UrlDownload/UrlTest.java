package com.udp.UrlDownload;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class UrlTest {
    public static void main(String[] args) throws IOException {
        //1.下载地址
        URL url = new URL("http://www.heishenhua.com/video/b1/gamesci_2021.mp4");

        //2.连接到这个资源 HTTP
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        //3.
        InputStream inputStream = urlConnection.getInputStream();

        FileOutputStream fos = new FileOutputStream("shunian.mp4");

        //这段代码要记住
        byte[] buffer = new byte[1024];
        int len;
        while ((len = inputStream.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        fos.close();
        inputStream.close();
        urlConnection.disconnect();//断开连接
    }
}
