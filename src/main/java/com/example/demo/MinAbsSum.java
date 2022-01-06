package com.example.demo;

import java.util.Arrays;

public class MinAbsSum {
    static int[] array = {1, 5, 2, -2};

    public static void main(String args[]) {
        System.out.println(solution(array));
    }

    public static int solution(int[] intArray) {
        int max = 0;
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = Math.abs(intArray[i]);
            max = Math.max(intArray[i], max);
        }

        int sumArray = sum(intArray);
        array = new int[sumArray + 1];
        int[] count = new int[max + 1];
        for (int i = 0; i < intArray.length; i++) {
            count[intArray[i]] += 1;
        }
        Arrays.fill(array, -1);
        array[0] = 0;
        for (int i = 1; i < max + 1; i++) {
            if (count[i] > 0) {
                for (int j = 0; j < sumArray; j++) {
                    if (array[j] >= 0) {
                        array[j] = count[i];
                    } else if (j >= i && array[j - i] > 0) {
                        array[j] = array[j - i] - 1;
                    }
                }
            }
        }
        int result = sumArray;
        for (int i = 0; i < Math.floor(sumArray / 2) + 1; i++) {
            if (array[i] >= 0) {
                result = Math.min(result, sumArray - 2 * i);
            }
        }
        return result;
    }

    public static int sum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }

        return sum;
    }

}
