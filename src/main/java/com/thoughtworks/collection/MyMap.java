package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        return array.stream().map(item -> 3 * item).collect(Collectors.toCollection(ArrayList::new));
    }

    public List<String> mapLetter() {
        String shit = "abcdefghijklmnopqrstuvwxyz";
        List<String> list = new ArrayList<>();
        for (Integer s : array) {
            String charAt = new String(String.valueOf(shit.charAt(s-1)));
            list.add(charAt);
        }
        return list;
    }

    public List<String> mapLetters() {
        String shit = "abcdefghijklmnopqrstuvwxyz";
        ArrayList<String>result = new ArrayList<>();
        for (Integer number : array) {
            number--;
            int x = number/26;
            int y = number%26;
            String s = "";
            if (x != 0) s += shit.charAt(x-1);
            s += shit.charAt(y);
            result.add(s);
        }
        return result;
    }

    public List<Integer> sortFromBig() {
        return array.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public List<Integer> sortFromSmall() {
        return array.stream().sorted().collect(Collectors.toList());
    }
}
