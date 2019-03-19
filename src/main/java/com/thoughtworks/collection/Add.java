package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        /*
        计算偶数之和
        算法：项数乘以平均值
        项数：fabs（a-b）/ 2 + 1 向下取整;
        平均值（a+b）/ 2 向上取整；
        */
//        int counter = Math.abs(leftBorder - rightBorder) / 2 + 1;
//        int average = (int)Math.ceil((leftBorder + rightBorder) / 2.0);
//        return counter * average;
        if (leftBorder > rightBorder){
            int temp = rightBorder;
            rightBorder = leftBorder;
            leftBorder = temp;
        }
        return IntStream.rangeClosed(leftBorder,rightBorder).filter(s->s%2==0).sum();
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
         /*
         计算奇数只和
        算法：项数乘以平均值
        */
//         int left =Math.min(leftBorder,rightBorder);
//         int right =Math.max(leftBorder,rightBorder);
//         if (left % 2 == 0) left++;
//         if (right % 2 == 0) right--;
//        return ((right - left) / 2 + 1) * (left + right) / 2;
        if (leftBorder > rightBorder){
            int temp = rightBorder;
            rightBorder = leftBorder;
            leftBorder = temp;
        }
        return IntStream.rangeClosed(leftBorder,rightBorder).filter(s->s%2 ==1).sum();
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream().mapToInt(ele -> 3 * ele + 2).sum();
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream().filter(s->s%2==1).mapToInt(ele->3*ele+5).sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
        return IntStream.range(0, arrayList.size()).mapToObj(i -> arrayList.get(i)%2 == 0 ?arrayList.get(i) :arrayList.get(i)*3+  2).collect(Collectors.toList());
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> arr = arrayList.stream().filter(s->s%2==0).sorted().collect(Collectors.toList());
        int size = arr.size();
        return  (size % 2 == 1)? arr.get(size/2) : (arr.get(size/2-1)+arr.get(size/2))/2;
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream().filter(s-> s%2 == 0).mapToInt(s->s).average().getAsDouble();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        return  arrayList.stream().filter(s->s%2==0).mapToInt(s->s).anyMatch(ele->ele == specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(s->s%2==0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> l1 = arrayList.stream().filter(s->s%2==0).sorted().collect(Collectors.toList());
        List<Integer> l2 = arrayList.stream().filter(s->s%2==1).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        l1.addAll(l2);
        return l1;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        return IntStream.range(0, arrayList.size() - 1).mapToObj(i -> (arrayList.get(i) + arrayList.get(i + 1)) * 3).collect(Collectors.toList());
    }
}
