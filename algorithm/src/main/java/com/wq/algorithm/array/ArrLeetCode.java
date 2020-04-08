package com.wq.algorithm.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrLeetCode {
    /**
     * 2020.4.1
     * two-nums
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i != j && nums[i] + nums[j] == target) {
                    int[] result = {i, j};
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * 2020.4.1
     * 官方使用hash表(通过)
     */
    public int[] towSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                int[] result = {map.get(temp), i};
                return result;
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }

    /**
     * 我的解答：利用sumA-sumB比为偶数，并且(sumA-sumB)/2=eleA-eleB
     * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
     * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
     * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
     * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/fair-candy-swap
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] fairCandySwap2(int[] A, int[] B) {
        Set<Integer> setA = new HashSet();
        Set<Integer> setB = new HashSet();
        int sumA = 0;
        int sumB = 0;
        for (int i = 0; i < A.length; i++) {
            setA.add(A[i]);
            sumA = sumA + A[i];
        }
        for (int i = 0; i < B.length; i++) {
            setB.add(B[i]);
            sumB = sumB + B[i];
        }
        int diff = sumA - sumB;
        if (diff % 2 == 0) {
            for (int ele : setA) {
                if (setB.contains(ele - diff / 2)) {
                    int[] result = {ele, ele - diff / 2};
                    return result;
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}
