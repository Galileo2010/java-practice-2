package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.List;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        return arrayList.stream().mapToInt(x->x).max().getAsInt();
    }

    public int getMinimum() {
        return arrayList.stream().mapToInt(x->x).min().getAsInt();

    }

    public double getAverage() {
        return arrayList.stream().mapToInt(x->x).average().getAsDouble();
    }

    public double getOrderedMedian() {
        int size = arrayList.size();
        if (size %2 == 0){
            return (arrayList.get(size/2-1)+arrayList.get(size/2))/2.0;
        }
        else
            return arrayList.get(size/2);
    }

    public int getFirstEven() {
        return arrayList.stream().filter(s->s%2==0).findFirst().get();
    }

    public int getIndexOfFirstEven() {
        for (int i = 0; i < arrayList.size(); i++)
            if (arrayList.get(i) % 2 == 0)
                return i;
        return -1;
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.containsAll(arrayList) && arrayList.containsAll(this.arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        return 0.0;    }

    public int getLastOdd() {
        for (int i = arrayList.size() - 1; i >= 0; i--)
            if (arrayList.get(i) % 2 == 1)
                return arrayList.get(i);
        return -1;
    }

    public int getIndexOfLastOdd() {
        for (int i = arrayList.size() - 1; i >= 0; i--)
            if (arrayList.get(i) % 2 == 1)
                return i;
        return -1;
    }
}
