package ArraysAndHashing;


import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] alphabets = new int[26];
        for (char c : s.toCharArray()) {
            int index = c - 'a';
            alphabets[index]++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            alphabets[index]--;
            if (alphabets[index] < 0)
                return false;
        }
        return Arrays.stream(alphabets).sum() == 0;
    }
}
