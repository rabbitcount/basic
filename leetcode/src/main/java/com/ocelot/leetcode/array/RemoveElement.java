package com.ocelot.leetcode.array;

import java.util.Objects;

/**
 * Created by gaoxiang on 2017/1/15.
 */
public class RemoveElement {

    /**
     * Question
     *   Given an array and a value, remove all instances of that value in place and return the new length.
     *   The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     *
     * Tip
     *   简单数组
     *
     * @param input 原始数组数组
     * @param elem  指定待移除的数据
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int removeElement(T[] input, T elem) {
        int lengthOfInput = getLength(input);
        // 如果待比较数据为空，则返回原始input数组的长度
        if (Objects.isNull(elem)) {
            return lengthOfInput;
        }

        int retIndex = 0; // 实际输出数组index
        // // 在原始数组中步进
        for (int oriIndex = 0; oriIndex < lengthOfInput; oriIndex++) {
            if (elem.compareTo(input[oriIndex]) == 0) {
                continue;
            }
            input[retIndex] = input[oriIndex];
            retIndex++;
        }
        return retIndex;
    }

    /**
     * Question
     *   Given a sorted array, remove the duplicates in place such that > each element appear only once and return the new length.
     *   Do not allocate extra space for another array, you must do this in place with constant memory.
     *   For example, Given input array A = [1,1,2],
     *   Your function should return length = 2, and A is now [1,2].
     *
     * Tips
     *
     * @param input
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int removeDuplicatesFromSortedArray(T[] input) {
        int lengthOfInput = getLength(input);
        if(lengthOfInput <= 1) {
            return lengthOfInput;
        }

        // 第一个元素保留，从第二个开始过滤
        int retIndex = 0;
        T value = input[++retIndex];
        for(int oriIndex = 1; oriIndex < lengthOfInput; ++oriIndex) {
            if(value.equals(input[oriIndex])) {
                continue;
            }
            // 不重复则在返回数组中复制，并保留值
            value = input[oriIndex];
            input[++retIndex] = input[oriIndex];
        }
        return retIndex + 1;
    }

    /**
     * Question
     *   Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
     *   For example, Given sorted array A = [1,1,1,2,2,3],
     *   Your function should return length = 5, and A is now [1,1,2,2,3].
     *
     * Tip
     *   重复次数多于指定数值的，需要去除，否则直接保留
     *
     *
     * @param input 输入
     * @param duplicateTimes 允许重复的次数
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int removeDuplicatesMoreThanTwice(T[] input, int duplicateTimes) {
        int lengthOfInput = getLength(input);
        if(lengthOfInput <= 1) {
            return lengthOfInput;
        }

        // 第一个元素保留，从第二个开始过滤
        int retIndex = 0;
        T value = input[retIndex];
        int count = 0;
        for(int oriIndex = 1; oriIndex < lengthOfInput; ++oriIndex) {
            if(value.equals(input[oriIndex]) && ++count > duplicateTimes) {
                continue;
            }
            // 不重复则在返回数组中复制，并保留值
            value = input[oriIndex];
            input[++retIndex] = input[oriIndex];
            count = 1;
        }
        return retIndex + 1;
    }

    private static <T> int getLength(T[] input) {
        if (Objects.isNull(input)) {
            return 0;
        }
        return input.length;
    }
}
