package com.bluesden;

public class Main {
    public static void main(String[] args) {
        String sequence = "1027839564";
        int[] sequenceIntArray = Convert.stringToIntArray(sequence);
        largestSeriesProduct(sequenceIntArray, 3);
    }

    public static void largestSeriesProduct(int[] sequence, int seriesSize) {
        if (seriesSize > sequence.length) {
            throw new ArithmeticException("The series size cannot be longer than the sequence length.");
        }

        int biggestNumber = 0;
        int seriesProduct;

        for (int i = 0; i < sequence.length ; i++) {
            if ((sequence.length - i) < seriesSize) {
                break;
            }

            seriesProduct = sequence[i];
            for (int j = 1; j < seriesSize; j++) {
                seriesProduct = seriesProduct * sequence[i+j];
            }

            if (seriesProduct > biggestNumber) {
                biggestNumber = seriesProduct;
            }
        }

        System.out.println(biggestNumber);
    }
}
