package io.dure.coding.array;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public int subArraySum(int[] nums, int k) {
        Map<Integer,Integer> sumToCount = new HashMap<>();
        sumToCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += sumToCount.getOrDefault(sum - k, 0);
            sumToCount.put(sum, sumToCount.getOrDefault(sum , 0) + 1);
        }
        return count;
    }
}
