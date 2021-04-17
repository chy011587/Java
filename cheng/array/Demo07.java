package com.cheng.array;

import java.util.Arrays;

public class Demo07 {
    public static void main(String[] args) {
        int[] array = {2, 1, 5, 3, 6, 4};
        int[] sort = sort(array);
        System.out.println(Arrays.toString(sort));
    }

    public static int[] sort(int[] array){
            int temp = 0;           //临时变量
            for (int i = 0; i < array.length - 1; i++) {
            //外层循环，判断我们要走多少次
                boolean flag = false;   //优化排序，省略步骤，提高效率
                for (int j = 0; j < array.length - 1 - i; j++) {
                //内层循环，判断比较两个数，如果第一个数比第二个数大(小)，则交换两个数
                    if (array[j + 1] < array[j]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        flag = true;
                    }
                }
                if (flag==false){
                    break;
                }
            }
            return array;
        }
}
