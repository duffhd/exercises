package com.bluesden;

public class Main {
    public static void main(String[] args) {
        int[] sequence1 = Convert.stringToIntArray("1027839564");
        int[] sequence2 = Convert.stringToIntArray("73167176531330624919225119674426574742355349194934");

        assert largestSeriesProduct(sequence1, 3) == 270;
        assert largestSeriesProduct(sequence1, 5) == 7560;
        assert largestSeriesProduct(sequence2, 6) == 23520;
    }

    public static int largestSeriesProduct(int[] sequence, int seriesSize) {
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

        return biggestNumber;
    }
}
