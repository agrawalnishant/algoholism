package com.somedomain.algos.arraysandstring;

import com.google.common.flogger.FluentLogger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ThreeSumClosest {
    private static final FluentLogger logger = FluentLogger.forEnclosingClass();

    static int[] arr = {-200, -55, -12, -7, 0, -1, -1, 0, 2, 28, 57, 98};

    public static void main(String[] args) {
        //testNearestNeighbour(arr);
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

        arr = new int[]{1, 1, 1, 1};
        target = 0;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); //3

        arr = new int[]{-1, -5, -3, -4, 2, -2};
        target = 0;
        System.out.println(Arrays.toString(arr) + " threeSumClosest to " + target + " is " + closestTripletSum(arr, target)); //-1
    }


    private static int closestTripletSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap(nums.length);
        for (int count = 0; count < nums.length; count++) {map.put(nums[count], count);}
        int len = nums.length, left = 0, right = len - 1, sumOf2 = 0, residue = 0;
        int maxCounter = len - 1;
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Integer closestSum = Integer.valueOf(10000);

        for (int counter1 = 0; counter1 < maxCounter; counter1++) {
            for (int counter2 = maxCounter; counter2 > counter1; counter2--) {
                Set<Integer> closestSumsInIteration = new HashSet<>();
                closestSumsInIteration.addAll(Arrays.stream(findSums(nums, map, counter1, counter2, target)).collect(Collectors.toList()));
                for (Integer sum : closestSumsInIteration) {
                    if (sum != null) {
                        if (sum == target) {
                            closestSum = target;
                            break;
                        } else if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                            closestSum = sum;
                        }
                    }
                }
            }
        }
        return closestSum;
    }

    private static Integer[] findSums(int[] nums, HashMap<Integer, Integer> map, int counter1, int counter2, int target) {
        Integer num1 = nums[counter1], num2 = nums[counter2];
        Integer[] sums = new Integer[2];
        if (counter1 == counter2) return sums;

        //System.out.println("findSums for " + nums[counter1] + ", " + nums[counter2]);

        Integer sumOf2 = num1 + num2;
        Integer residue = target - sumOf2;
        Integer idx = map.get(residue);
        if (idx != null && idx != counter1 && idx != counter2) {
            sums[0] = target;
        } else {
            Integer[] neighbours = findNeighbours(nums, counter1, counter2, residue);
            for (Integer neighbourPos : neighbours) {
                if (neighbourPos != null) {
                    if (neighbourPos != counter1 && neighbourPos != counter2) {
                        int tmpSum = sumOf2 + nums[neighbourPos];
                        //System.out.println("Sum:" + sumOf2 + " + " + neighbour + " = " + tmpSum);
                        if (sums[0] == null) {
                            sums[0] = tmpSum;
                        } else {
                            sums[1] = tmpSum;
                        }
                    }
                }
            }
        }
        //System.out.println("Sums:\t :" + sums[0] + " and " + sums[1]);
        return sums;
    }

    private static Integer[] findNeighbours(int[] nums, int leftCounter, int rightCounter, int residue) {
        int left = 0, right = nums.length - 1;
        Integer[] neighboursPos = new Integer[2];
        if (residue <= nums[0]) {
            if (leftCounter == 0) neighboursPos[0] = 1;
            else neighboursPos[0] = 0;
        } else if (residue >= nums[nums.length - 1]) {
            if (rightCounter == nums.length - 1) neighboursPos[0] = nums.length - 2;
            else neighboursPos[0] = nums.length - 1;
        } else {
            while (left < right) {
                int mid = left + ((right - left) / 2);
                int leftPos = mid - 1;
                int midPos = mid;
                int rightPos = mid + 1;

                if (residue >= nums[leftPos] && residue <= nums[rightPos]) {
                    if (mid == leftCounter || mid == rightCounter || mid - 1 == leftCounter || mid + 1 == rightCounter) {
                        if (mid - 1 == leftCounter) {
                            if (mid - 2 >= 0) {
                                leftPos = mid - 2;
                            } else {
                                neighboursPos[0] = rightPos;
                                return neighboursPos;
                            }
                        } else if (mid + 1 == rightCounter) {
                            if (mid + 2 <= nums.length - 1) {
                                rightPos = mid + 2;
                            } else {
                                neighboursPos[0] = leftPos;
                                return neighboursPos;
                            }
                        }
                    } else if (residue >= nums[leftPos] && residue <= nums[midPos]) {
                        rightPos = midPos;
                    } else {
                        leftPos = midPos;
                    }
                    int leftDiff = Math.abs(residue - nums[leftPos]);
                    int rightDiff = Math.abs(nums[rightPos] - residue);
                    if (leftDiff == rightDiff) {
                        neighboursPos[0] = leftPos;
                        neighboursPos[1] = rightPos;
                    } else if (leftDiff < rightDiff) {
                        neighboursPos[0] = leftPos;
                    } else {
                        neighboursPos[0] = rightPos;
                    }
                    break;
                } else if (residue <= nums[midPos]) {
                    right = mid;
                } else {
                    left = mid;
                }
            }
        }
        // System.out.println("Neighbour Pos of " + residue + " are " + neighboursPos[0] + " and " + neighboursPos[1]);
        return neighboursPos;
    }
}
