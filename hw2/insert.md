# 插入排序各操作耗时分析

## 一、插入排序原理
>**插入排序是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

## 二、操作耗时分析流程
- 设计源代码，通过一定的循环实现插入排序
```C
import java.util.Random;

public class Sort {
    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i-1]) return false;
        }
        return true;
    }

    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && a[j] < a[j-1]; j--) {
                int tmp = a[j];
                a[j] = a[j-1];
                a[j-1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[100000];
        for (int i = 0; i < 100000; i++) {
            a[i] = new Random().nextInt(10000);
        }
        assert !isSorted(a);
        sort(a);
        assert isSorted(a);
    }
}
```

- 下载IDEA旗舰版，利用其中的Profile工具进行分析：
1. 在[官网](https://www.jetbrains.com/idea/)获取学生许可证，下载IDEA旗舰版；
2. 利用Profile工具，获取各个函数的cpu占用情况；
3. 对比分析各个函数的耗时情况，最终分析得到最耗时的操作

## 三、分析结论
通过Profile工具中的图像，不难发现最耗时的操作在于排序队列的遍历，即确定相关数据插入的位置。
