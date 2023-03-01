package ArraysAndHashing;

import java.util.*;

public class TopKElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        Arrays.stream(nums).forEach(value -> freqMap.put(value, freqMap.getOrDefault(value, 0) + 1));
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        freqMap.entrySet().stream().forEach(entry -> {
            int freq = entry.getValue();
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(entry.getKey());
        });
        int[] result = new int[k];
        int index = 0;

        for (int i = nums.length; i >= 0; i--) {
            if (bucket[i] != null) {
                for (int val : bucket[i]) {
                    result[index++] = val;
                    if (index == k)
                        return result;
                }
            }
        }
        return result;
    }
}
