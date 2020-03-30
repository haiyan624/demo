package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

@RestController
@RequestMapping("/test")
public class Test {

    @RequestMapping(value = {"/conf"}, method = RequestMethod.GET)
    public ResponseEntity<String> getEmailConfPage() throws Exception {
        this.testBubbleSort();
        return new ResponseEntity<String>("sssssss", HttpStatus.OK);
    }

    private int testNum;

    /**
     * 这个方法在feature分支提交
     */
    public void featureTest(){

    }
    public void testBubbleSort() {
//		int[] arr={7,2};
//		this.bubbleSort(arr);
//		printArr(arr);
//        int[] arr2={8,2,4,5,1,3,7,6,0};
//        int[] arr2={0,1,2,3,4,5,6,7,8};
//        int[] arr2={6,1,2,7,9,3,4,5,10,8};
        int[] arr2 = {11, 51, 88, 69, 9, 8, -99, 77, 7, 6, 5, 4, 3, 2, 1, -1, 50};
//		testNum = 0;
//        this.quickSort(arr2,0,8);
//        List<Integer> list1 =new LinkedList<>();
//		list1.add(8);
//		list1.add(2);
//		list1.add(4);
//		list1.add(5);
//		list1.add(1);
//		list1.add(3);
//		list1.add(7);
//		list1.add(6);
//		list1.add(8);
//		list1.add(8);
//		this.inserSort(list1);
//		this.shellSort(arr2);
//		this.selectionSort(arr2);
        this.sort(arr2);
//		printArr(arr2);
    }

    /**
     * 冒泡排序（稳定排序）
     * 最好O(n)
     * 平均O(n^2)
     * 最坏(n^2)
     * 空间复杂度：O(1)
     *
     * @param arr
     */
    public void bubbleSort(int arr[]) {
        boolean hasSwap = false;
        for (int i = 0, len = arr.length; i < len - 1; i++) {
            for (int j = len - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j - 1, j);
                    hasSwap = true;
                }
            }
            if (!hasSwap) {
                return;
            }
        }
    }

    private void printArr(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    /**
     * 快速排序
     * 时间复杂度最好，平均，最差：O(nlogn)，O(nlogn)，O(n^2)
     * 空间复杂度O(nlogn)
     *
     * @param arr
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int index = divi(arr, left, right);
            quickSort(arr, left, index - 1);
            quickSort(arr, index + 1, right);
            printArr(arr);
        }
        System.out.println("-----------" + testNum);
    }

    private int divi(int[] arr, int left, int right) {
        if (left < right) {
            int base = arr[left];
            while (left < right) {
                while (left < right && arr[right] >= base) {
                    testNum++;
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left] <= base) {
                    testNum++;
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = base;

        }
        return left;
    }


    /**
     * 插入排序
     * 最好，平均，最差：O(n),O(n^2),O(n^2)
     * 空间O(1)
     *
     * @param list
     */
    public void inserSort(List<Integer> list) {
        for (int i = 0, len = list.size(); i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (list.get(j) < list.get(i)) {
                    list.add(i, list.get(j));
                    list.remove(j + 1);
                }
            }
        }
    }

    /**
     * 希尔排序
     *
     * @param list
     */
    public void shellSort(int[] list) {
        int len = list.length;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int temp = list[i];
                int j = i - gap;

                for (; j >= 0 && list[j] > temp; j = j - gap) {
                    list[j + gap] = list[j];
                }
                list[j + gap] = temp;
            }
            gap = gap / 2;
        }
    }

    public void shellSort2(int[] list) {
        int gap = list.length / 2;

        while (1 <= gap) {
            // 把距离为 gap 的元素编为一个组，扫描所有组
            for (int i = gap; i < list.length; i++) {
                int j = 0;
                int temp = list[i];
                // 对距离为 gap 的元素组进行排序
                for (j = i - gap; j >= 0 && temp < list[j]; j = j - gap) {
                    list[j + gap] = list[j];
                }
                list[j + gap] = temp;
            }
            System.out.format("gap = %d:	", gap);
//			printAll(list);
            gap = gap / 2; // 减小增量
        }
    }

    public void selectionSort(int[] list) {

        for (int i = 0, len = list.length; i < len - 1; i++) {
            int min = i;
            int temp = list[i];
            for (int j = i + 1; j < len; j++) {
                if (list[j] < temp) {
                    min = j;
                }
            }
            if (min != i) {
                swap(list, i, min);
            }
        }
    }

    /**
     * 基数排序
     * 考虑负数的情况还可以参考： https://code.i-harness.com/zh-CN/q/e98fa9
     */

    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int maxDigit = getMaxDigit(arr);
        return radixSort(arr, maxDigit);
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    private int getMaxValue(int[] arr) {
        int maxValue = arr[0];
        for (int value : arr) {
            if (maxValue < value) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    protected int getNumLenght(long num) {
        if (num == 0) {
            return 1;
        }
        int lenght = 0;
        for (long temp = num; temp != 0; temp /= 10) {
            lenght++;
        }
        return lenght;
    }

    private int[] radixSort(int[] arr, int maxDigit) {

        for (int i = 0; i < maxDigit; i++) {
            int[][] temp = new int[19][0];
            for (int j = 0; j < arr.length; j++) {
                int bucket = this.getBucket(i, arr[j]);
                temp[bucket] = this.arrayAppend(temp[bucket], arr[j]);
            }
            int index = 0;
            for (int index1 = 0; index1 < temp.length; index1++) {
                for (int index2 = 0; index2 < temp[index1].length; index2++) {
                    arr[index++] = temp[index1][index2];
                }
            }
        }
        printArr(arr);
        return arr;
    }


    private int getBucket(int digit, int data) {
        int div = (int) Math.pow(10, digit);
        int temp = data / div;
        return temp - temp / 10 * 10 + 9;
    }

    /**
     * 自动扩容，并保存数据
     *
     * @param arr
     * @param value
     */
    private int[] arrayAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    /**
     * 非递归
     */
    public void qSort2(int[] a, int low, int high) {
        int pivot;
        if (low >= high) {
            return;
        }
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(low);
        stack.push(high);
        while (!stack.empty()) {
            // 先弹出high,再弹出low
            high = stack.pop();
            low = stack.pop();
            pivot = divi(a, low, high);
            // 先压low,再压high
            if (low < pivot - 1) {
                stack.push(low);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < high) {
                stack.push(pivot + 1);
                stack.push(high);
            }
        }
    }
}
