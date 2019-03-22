package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        ArrayList<Integer> result = new ArrayList<>();
        if (left <= right) for (int i = left; i <= right; i++)
            result.add(i);
        else
            for (int i = left; i >= right; i--)
                result.add(i);
        return result;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        if (left < right){
            return IntStream.rangeClosed(left,right).filter(s->s%2==0).boxed().collect(Collectors.toList());
        }
        else {
            return IntStream.rangeClosed(right,left).filter(s->s%2==0).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        }
    }

    public List<Integer> popEvenElments(int[] array) {
        return Arrays.stream(array).boxed().filter(s->s%2==0).collect(Collectors.toList());
    }

    public int popLastElment(int[] array) {
        List<Integer> result = Arrays.stream(array).boxed().collect(Collectors.toList());
        return result.get(result.size()-1);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        // int[]=>Integer[]=>List<Integer>
        List<Integer> result = Arrays.stream(firstArray).boxed().collect(Collectors.toList());
        result.retainAll(Arrays.stream(secondArray).boxed().collect(Collectors.toList()));
        return  result;
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> first = Arrays.stream(firstArray).collect(Collectors.toList());
        List<Integer> second = Arrays.stream(secondArray).collect(Collectors.toList());
        for (Integer item : second) {
            if (!first.contains(item)) first.add(item);
        }
        return first;
    }
}
