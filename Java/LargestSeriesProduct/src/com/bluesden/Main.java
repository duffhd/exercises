package com.bluesden;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> sequence1 = Convert.stringToIntArray("1027839564");
        List<Integer> sequence2 = Convert.stringToIntArray("73167176531330624919225119674426574742355349194934");

        assert largestSeriesProduct(sequence1, 3) == 270;
        assert largestSeriesProduct(sequence1, 5) == 7560;
        assert largestSeriesProduct(sequence2, 6) == 23520;
    }

    public static int largestSeriesProduct(List<Integer> sequence, int seriesSize) {
        if (seriesSize > sequence.size()) {
            throw new ArithmeticException("The series size cannot be longer than the sequence length.");
        }

        int biggestNumber = 0;
        int seriesProduct;

        for (int i = 0; i < sequence.size() ; i++) {
            if ((sequence.size() - i) < seriesSize) {
                break;
            }

            seriesProduct = sequence.get(i);
            for (int j = 1; j < seriesSize; j++) {
                seriesProduct = seriesProduct * sequence.get(i + j);
            }

            if (seriesProduct > biggestNumber) {
                biggestNumber = seriesProduct;
            }
        }

        return biggestNumber;
    }
}
