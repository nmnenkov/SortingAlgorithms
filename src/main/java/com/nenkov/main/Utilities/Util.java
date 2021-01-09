/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nenkov.main.Utilities;

import java.util.Arrays;

/**
 *
 * @author Nenkov
 */
public final class Util {

    public static int[] generateRandomArray(int arrSize, int minValue, int maxValue) {
        int[] respArray = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            respArray[i] = (int) (Math.random() * (maxValue - minValue + 1) + minValue);
        }
        return respArray;
    }

    public static final int genRandomInt(int min, int max) {

        return (int) (Math.random() * (max - min + 1) + min);
    }

    public final static String printArray(int[] arr) {
        return Arrays.toString(arr);
    }

    public final static String printArrayWithBubble(int[] arr, int bubbleIndex) {
        StringBuffer sb = new StringBuffer();
        int arrLen = arr.length;
        if (arrLen == 0) {
            return "";
        }
        sb.append("[");
        for (int i = 0; i < arrLen; i++) {
            if (i == bubbleIndex) {
                sb.append("( ");
            }

            sb.append(arr[i] + (i != arrLen - 1 ? ", " : ""));

            if (i == bubbleIndex + 1) {
                sb.append(") ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
