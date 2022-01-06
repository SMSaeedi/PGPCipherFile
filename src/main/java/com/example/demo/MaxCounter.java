package com.example.demo;

import java.util.Arrays;

public class MaxCounter {
    static int[] intArray = {3, 4, 4, 6, 1, 4, 4};
    static int n = 5;

    public static void main(String[] args) {
        int[] result = solution(n, intArray);
        System.out.println(result.length);
    }

//    public static int[] solution(int N, int[] A) {
//        int counter[] = new int[N];
//        int max = -1, current_min = 0;
//
//        for (int i : A) {
//            if (A[i] >= 1 && A[i] <= N) {
//                if (counter[A[i] - 1] < current_min) counter[A[i] - 1] = current_min;
//                counter[A[i] - 1] = counter[A[i] - 1] + 1;
//                if (counter[A[i] - 1] > max) max = counter[A[i] - 1];
//            } else if (A[i] == N + 1) {
//                current_min = max;
//            }
//        }
//        for (int i = 0; i < N; i++) {
//            if (counter[i] < current_min) counter[i] = current_min;
//        }
//        return counter;
//    }

    public static int[] solution(int N, int[] A) {
        final int condition = N + 1;
        int currentMax = 0;
        int lastUpdate = 0;
        int countersArray[] = new int[N];

        for (int iii = 0; iii < A.length; iii++) {
            int currentValue = A[iii];
            if (currentValue == condition) {
                lastUpdate = currentMax;
            } else {
                int position = currentValue - 1;
                if (countersArray[position] < lastUpdate)
                    countersArray[position] = lastUpdate + 1;
                else
                    countersArray[position]++;

                if (countersArray[position] > currentMax) {
                    currentMax = countersArray[position];
                }
            }

        }

        for (int iii = 0; iii < N; iii++) {
            if (countersArray[iii] < lastUpdate)
                countersArray[iii] = lastUpdate;
        }

        return countersArray;
    }
}