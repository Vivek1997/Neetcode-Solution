package ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> integerSet = new HashSet<>();
        for (int i : nums)
            integerSet.add(i);
        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!integerSet.contains(nums[i] - 1)) {
                int length = 0;
                while (integerSet.contains(nums[i] + length))
                    length += 1;
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
