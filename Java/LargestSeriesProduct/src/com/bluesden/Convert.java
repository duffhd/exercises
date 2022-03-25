package com.bluesden;

import java.util.Arrays;
import java.util.List;

public class Convert {
    public static List<Integer> stringToIntArray(String sequence) {
        return Arrays.stream(sequence.split("")).map(Integer::parseInt).toList();
    }
}
