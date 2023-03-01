package ArraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        //Generate hash based on alphabets
        Map<String, List<String>> groupedAnagram = new HashMap<>();
        for (String s : strs) {
            String key = generateHash(s);
            if (!groupedAnagram.containsKey(key))
                groupedAnagram.put(key, new ArrayList<>());
            groupedAnagram.get(key).add(s);
        }

        return new ArrayList<>(groupedAnagram.values());
    }

    private String generateHash(String s) {
        int[] charFreq = new int[26];
        for (char c : s.toCharArray())
            charFreq[c - 'a']++;
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < charFreq.length; i++) {
            if (charFreq[i] != 0) {
                char alphabet = (char) ('a' + i);
                key.append(charFreq[i] + String.valueOf(alphabet));
            }
        }
        return key.toString();
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams.groupAnagrams(strs);
    }
}
