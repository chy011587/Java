package com.iostream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 *1.输出字节流  OutputStream
 *2.输出字节节点流  具有实际传输数据的功能   (文件路径，boolean append)  true代表追加，不覆盖
 *3.IOException异常是FileNotFoundException异常的父类，所以只需要抛出父类异常即可
 *特别注意：FileOutputStream是不会自动创建文件夹以及多级文件夹的，它只会给你创建文件，而你是需要提供路径的，假如不提供路径默认创建在根目录下！
 */

public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        /*
         * 注意：路径正确但是文件（.txt）不存在，则会自动创建一个！
         * 传入的参数是绝对路径，那你的电脑必须有路径存在，否则报错！
         * Exception in thread "main" java.io.FileNotFoundException: D:\hello\temp.txt (系统找不到指定的路径。)
         */
        FileOutputStream fileOutputStream1 = new FileOutputStream("C:/Users/Cheng/Desktop/Java/testoutputstream.txt");
        fileOutputStream1.write(65);//出现A   AScII码
        /*
         * 注意：Files文件是自己创建，text文件可以自动生成！
         * 传入的参数是相对路径与上一种形势等价，相对在当前项目路径下，寻找该路径和文件
         * 如果没有找到的话，它会在你项目的根目录下创建temp.txt
         */
        fileOutputStream1.write('B');//直接写入字符B
        String s = "你好";
        byte[] bytes =s.getBytes();//获取字节存入字节数组中
        System.out.println(bytes.length);//查找出两个长度：2
        System.out.println(bytes[0]+" "+bytes[1]);//查找出两个字节数：-28、-67
        fileOutputStream1.write(bytes);//直接写入bytes字节数组，这时候在文件中就可以看到：你好

        byte[] bytes1 = new byte[]{65,66,67,68,'E'};//如果我们想写入多个字节，就可以用数组去写入了
        fileOutputStream1.write(bytes1);//直接写入整个字节数组的所有字节
        fileOutputStream1.write(bytes1,1,3);
        /*
         * 第一个参数：写入的字节数组
         * 第二个参数：起始下标，从哪个下标的字节开始写入
         * 第三个参数：长度，从起始下标开始写入几个下标长度的字节
         */

    }
}
