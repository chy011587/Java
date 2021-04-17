package com.cheng.scanner;

        import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        //输入多个数字，求出整合及平均数，如果输入非数字，结束输入并输出执行结果

        Scanner scanner = new Scanner(System.in);

        //和
        double sum = 0;
        //计算输入了多少数字
        int m = 0;
        System.out.println("请输入数字：");
        //通过循环判断是否还有输入，并在里面对每一次进行求和统计
        while (scanner.hasNextDouble()){
            double x = scanner.nextDouble();
            m = m + 1;
            sum = sum + x;
            System.out.println("你输入了第"+m+"个数据，当前的和为"+sum);
        }
        System.out.println(m+"个数的和为"+sum);
        System.out.println(m+"个数的平均值为"+(sum / m));



        scanner.close();
    }
}
