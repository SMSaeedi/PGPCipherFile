package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.lang.Integer;


public class BinaryCode {
    static int intValue = 123654;

    public static void main(String[] args) {
        String binaryVal = Integer.toBinaryString(intValue);
        System.out.println
        ("Int Value: "+ intValue +"Binary of Int Value: "+ binaryVal +"The largest BinGap "+ binaryGap(intValue));
    }

    public static int binaryGap(int n) {
        n >>>= Integer.numberOfTrailingZeros(n);
        int steps = 0;
        while ((n & (n + 1)) != 0) {
            n |= n >>> 1;
            steps++;
        }
        return steps;
    }

}
