package com.fishercoder.solutions;

import java.util.HashMap;
import java.util.Map;

public class _560 {

    public static class Solution1 {
        /**
         * credit: https://discuss.leetcode.com/topic/87850/java-solution-presum-hashmap
         * We know the key to solve this problem is SUM[i, j].
         * So if we know SUM[0, i - 1] and SUM[0, j],
         * then we can easily get SUM[i, j] via (SUM[0, j] - SUM[0, i-1]).
         * To achieve this, we just need to go through the array,
         * calculate the current sum and save number of all seen PreSum to a HashMap.
         * <p>
         * Time complexity O(n), Space complexity O(n).
         */
        public int subarraySum(int[] nums, int k) {
            Map<Integer, Integer> preSum = new HashMap();
            int sum = 0;
            int result = 0;
            preSum.put(0, 1);
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (preSum.containsKey(sum - k)) {
                    result += preSum.get(sum - k);
                }
                preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
            }
            return result;
        }
    }

}
