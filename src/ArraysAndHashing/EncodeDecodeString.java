package ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs)
            stringBuilder.append(s.length()).append("#").append(s);
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int length = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            if (c == '#') {
                result.add(str.substring(i + 1, i + 1 + length));
                i = i + 1 + length;
                length = 0;
                continue;
            }
            length = (length * 10) + Character.getNumericValue(c);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        EncodeDecodeString encodeDecodeString = new EncodeDecodeString();
        List<String> list = Arrays.asList("lint", "code", "love", "you");
        //4#lint4#code4#love3#you
        String encoded = encodeDecodeString.encode(list);
        System.out.println(encoded);
        //[lint, code, love, you]
        System.out.println(encodeDecodeString.decode(encoded));
    }
}
