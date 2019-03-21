package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        ArrayList<Integer>result = new ArrayList<>();
        for (Integer[] subarray : array)
                result.addAll(Arrays.asList(subarray));
        return result;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        ArrayList<Integer>result = new ArrayList<>();
        for (Integer[] subarray : array)
            result.addAll(Arrays.asList(subarray));
        return result.stream().distinct().collect(Collectors.toList());
    }
}
