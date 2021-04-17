package com.iostream;

import java.io.*;

public class TestBufferedOutput {
    public static void main(String[] args) throws IOException {
        //有参构造需要一个字节流输出节点流
        //先创建一个输出节点流
        FileOutputStream fileOutputStream = new FileOutputStream("C:/Users/Cheng/Desktop/Java/buff.txt");
        //增强节点流（类似用增强的工具做了包装）
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        //过滤流的write方法，是先写入到缓冲区数组里！
        bufferedOutputStream.write('A');
        bufferedOutputStream.write('B');
        bufferedOutputStream.write('C');
        bufferedOutputStream.write('D');

        //刷新缓冲区（将缓冲区的数组，一次性写入到文件中，并清空当前缓冲区）
        //如果不刷新的话，我们的文件中将会是空的！
        bufferedOutputStream.flush();

        bufferedOutputStream.write('E');
        bufferedOutputStream.write('F');

        bufferedOutputStream.flush();
        //级联的执行了flush()释放资源的同时
        //将缓冲区的数据刷新了，也就是将缓冲区的数据一次性写入到文件里
        //就省略使用了flush()方法去刷新缓冲区了（更方便）
        bufferedOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("C:/Users/Cheng/Desktop/Java/buff.txt");
        //增强节点流（方法和上限的输出流一致，这个是输入流，这里我就不再写一遍了）
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes = new byte[10];
        fileInputStream.read(bytes);
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]+" ");//A B C D E F G（其实还多打印了很多多余长度的空格）
        }

    }
}
