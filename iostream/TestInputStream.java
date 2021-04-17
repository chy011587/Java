package com.iostream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestInputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Cheng/Desktop/Java/testinputstream.txt");
        //写入一个A
        fileOutputStream.write('A');

        FileInputStream fileInputStream = new FileInputStream("C:/Users/Cheng/Desktop/Java/testinputstream.txt");
        System.out.println((char) fileInputStream.read());//读出一个A，如果不做强转的话，会出现打印的字节数65

        //这里我们在文件中多写入几个值
        fileOutputStream.write('B');
        fileOutputStream.write('C');
        fileOutputStream.write('D');
        fileOutputStream.write('E');

        //用普通的方法读只能一个一个的读，这里写一个死循环读一下试试
//        while (true){
//            int n = fileInputStream.read();
//            if (n==-1){
//                break;
//            }
//            System.out.println((char)n+" ");
//        }

        //如果我们用数组存储字节来读文件怎么样呢？
        byte[] bytes = new byte[4];//该数组作为读时的存储，数组长度为4
        while (true){
            int count = fileInputStream.read(bytes);//每次读出数组中有效字节数
            if (count==-1){//停止读的条件
                break;
            }
            /*
             * 读多少个打印多少个
             * 假如读数组长度的haul会出现小问题
             * 我们从文件中读出是按数组长度一组组的读出来的
             * 假如最后一个字节是数组长度中的第一个，而后面的三个就会被上面一个数组打印出来的结果的缓冲区影响
             * 从而多读出了3个上一次读出数组的缓冲区数字，不信你可以去试试，毕竟实践出真知嘛！
             */
            for (int i = 0; i < count; i++) {//读有效个数，也就是从count
                System.out.println((char)bytes[i]+" ");//B C D E（因为上一个读操作会对这一次的读操作产生影响，所以我就把上一个操作注掉了！)
            }
        }

    }
}
