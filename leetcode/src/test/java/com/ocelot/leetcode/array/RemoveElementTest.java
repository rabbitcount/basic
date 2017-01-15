package com.ocelot.leetcode.array;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by gaoxiang on 2017/1/15.
 */
public class RemoveElementTest {

    // --removeElement-------------------------------------------------

    @Test
    public void removeElementNullInputTest() {
        int result = RemoveElement.removeElement(null, 100);
        assertEquals(result, 0);
    }

    @Test
    public void removeElementWithNullSpecfiedValueTest() {
        Context context = createContext(100, 5);
        int result = RemoveElement.removeElement(context.getInput(), null);
        assertEquals(context.getInput().length, result);
    }

    @Test
    public void removeElementWithNonExistsValueTest() {
        Context context = createContext(100, 34);
        int result = RemoveElement.removeElement(context.getInput(), 35);
        assertEquals(context.getInput().length, result);
    }

    @Test
    public void removeElementTest() {
        Context context = createContext(20, 5);
        int result = RemoveElement.removeElement(context.getInput(), context.getSpecfiedValue());
        assertEquals(context.getInput().length - context.getDummyCount(), result);
    }

    private Context createContext(int oriLength, int max) {
        Random random = new Random(System.currentTimeMillis());
        int specfiedValue = random.nextInt(max);
        Integer[] input = new Integer[oriLength];
        int dummyCount = 0;
        for(int index = 0; index < oriLength; index++) {
            int randomValue = random.nextInt(max);
            if(randomValue == specfiedValue) {
                ++dummyCount;
            }
            input[index] = randomValue;
        }
        return new Context(input, specfiedValue, dummyCount);
    }

    class Context {
        private Integer[] input;
        private Integer specfiedValue; // 待删除的值
        private int dummyCount; // 待删除指定值个数

        Context(Integer[] input, Integer specfiedValue, int dummyCount) {
            this.input = input;
            this.specfiedValue = specfiedValue;
            this.dummyCount = dummyCount;
        }

        public Integer[] getInput() {
            return input;
        }

        public Integer getSpecfiedValue() {
            return specfiedValue;
        }

        public int getDummyCount() {
            return dummyCount;
        }

    }

    // --removeDuplicatesFromSortedArray------------------------------------

    // 一般测试
    @Test
    public void removeDuplicatesFromSortedArrayTest() {
        Context context = createContext(100, 120);
        Arrays.sort(context.getInput());
        Set<Integer> removed = filterDuplicate(context.getInput());
        int length = RemoveElement.removeDuplicatesFromSortedArray(context.getInput());
        assertEquals(removed.size(), length);
    }

    @Test
    public void removeDuplicatesFromSortedArrayWithNull() {
        int length = RemoveElement.removeDuplicatesFromSortedArray(null);
        assertEquals(0, length);
    }

    @Test
    public void removeDuplicatesFromSortedArrayTestWithSingleInput() {
        Context context = createContext(1, 100);
        int length = RemoveElement.removeDuplicatesFromSortedArray(context.getInput());
        assertEquals(1, length);
    }

    private Set<Integer> filterDuplicate(Integer[] input) {
        Set<Integer> removed = new HashSet<>();
        for(Integer i: input) {
            removed.add(i);
        }
        return removed;
    }

    // --removeDuplicatesMoreThanTwice------------------------------------

    @Test
    public void removeDuplicatesMoreThanTwiceTest() {
        Context context = createContext(100, 120);
        int duplicateTimes = 2;
        Arrays.sort(context.getInput());
        Map<Integer, List<Integer>> map = retainSpecfiedDuplicateValues(context.getInput(), duplicateTimes);
        int expectedResultLength = getLength(map);
        int resultLength = RemoveElement.removeDuplicatesMoreThanTwice(context.getInput(), duplicateTimes);
        assertEquals(expectedResultLength, resultLength);
    }

    /**
     * 保留指定数量荣誉
     * @return
     */
    private Map<Integer, List<Integer>> retainSpecfiedDuplicateValues(Integer[] input, int duplicateTimes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(Integer i: input) {
            if(map.containsKey(i)) {
                if (map.get(i).size() < duplicateTimes) {
                    map.get(i).add(i);
                }
            } else {
                List<Integer> l = new LinkedList<>();
                l.add(i);
                map.put(i, l);
            }
        }
        return map;
    }

    private int getLength(Map<Integer, List<Integer>> map) {
        int count = 0;
        if(Objects.nonNull(map)) {
            for(Map.Entry<Integer, List<Integer>> e: map.entrySet()) {
                count += e.getValue().size();
            }
        }
        return count;
    }
}
