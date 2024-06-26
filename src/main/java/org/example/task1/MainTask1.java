package org.example.task1;

import java.util.Arrays;
import java.util.Scanner;

public class MainTask1 {
    public static void main(String[] args) {
        int nElements = 5;
        int mSeparator = 4;
        generateArrays(nElements, mSeparator);
    }

    private static void generateArrays(int nElements, int mSeparator) {
        int[] arr = new int[nElements];

        Arrays.setAll(arr, i -> ++i);

        int current = 0;
        do {
            System.out.print(arr[current] + " ");
            current = (current + mSeparator - 1) % nElements;
        } while (current != 0);

    }
}
