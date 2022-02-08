package com.bluesden;

public class Convert {
    public static int[] stringToIntArray(String sequence) {
        int[] intArray = new int[sequence.length()];
        String[] strings = sequence.split("");

        for (int i = 0; i < sequence.length(); i++) {
            intArray[i] = Integer.parseInt(strings[i]);
        }

        return intArray;
    }
}
