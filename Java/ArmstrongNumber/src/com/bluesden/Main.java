package com.bluesden;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a number and check if it's an armstrong number.");

        String armstrongNumber = input.nextLine();
        System.out.println(isArmstrongNumber(armstrongNumber));
    }

    public static boolean isArmstrongNumber(String armstrongNumber) {
        int length = armstrongNumber.length();
        List<Integer> intList = Arrays
                .stream(armstrongNumber.split(""))
                .map(Integer::parseInt).toList();
        int calculatedArmstrongNumber = listPower(intList, length);

        return (calculatedArmstrongNumber == Integer.parseInt(armstrongNumber));
    }

    public static int listPower(List<Integer> numbers, int times) {
        int finalNumber = 0;

        for (int i : numbers) {
            finalNumber += Math.pow(i, times);
        }

        return finalNumber;
    }
}
