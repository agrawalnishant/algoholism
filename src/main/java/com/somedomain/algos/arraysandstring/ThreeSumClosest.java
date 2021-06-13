package com.somedomain.algos.arraysandstring;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;

public class ThreeSumClosest {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    static int[] arr = {-200, -55, -12, -7, 0, -1, -1, 0, 2, 28, 57, 98};

    public static void main(String[] args) {
        //testNearestNeighbour(arr);
        long startTime = System.currentTimeMillis();
        int target = 11;
        arr = new int[]{-200, -55, -12, -7, 0, -1, -1, 0, 2, 28, 57, 98};
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); //9

        arr = new int[]{-3, 2, 1, -4, 0, 100};
        target = 11;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); //3

        arr = new int[]{-1, 2, 1, -4};
        target = 1;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); //2

        arr = new int[]{0, 2, 1, -3}; //
        target = 1;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); // 0

        arr = new int[]{-3, -2, -5, 3, -4};
        target = -1;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); // -2

        arr = new int[]{1, -3, 3, 5, 4, 1};
        target = 1;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target));
        // 1


        arr = new int[]{-100, -98, -2, -1};
        target = -101;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target));
        //-101

        arr = new int[]{1, 2, 5, 10, 11};
        target = 12;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target));
        //13


        arr = new int[]{-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33};
        target = 0;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); //0
        System.out.println("Time: " + (System.currentTimeMillis() - startTime));

        arr = new int[]{1, 1, 1, 1};
        target = 0;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); //3

        arr = new int[]{-1, -5, -3, -4, 2, -2};
        target = 0;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); //-1
        System.out.println("Time: " + (System.currentTimeMillis() - startTime));
    }


    private static int closestTripletSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length, closestSum = nums[0] + nums[1] + nums[2];
        if (nums.length == 3 || nums[0] == nums[len - 1]) {
            return closestSum;
        }
        int currentMinDiff = Math.abs(target - closestSum);
        int currentDiff = currentMinDiff;
        for (int outerIdx = 0; outerIdx < len - 2; outerIdx++) {
            int left = outerIdx + 1, right = len - 1;
            while (left < right) {
                int sum = nums[outerIdx] + nums[left] + nums[right];
                currentDiff = Math.abs(target - sum);
                if (currentDiff < currentMinDiff) {
                    closestSum = sum;
                    currentMinDiff = currentDiff;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }

            }
        }
        return closestSum;
    }
}
