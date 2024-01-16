import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        isAnagram("anagram", "nagaram");
    }

    public static boolean isAnagram(String s, String t) {
        // Time: O(nlogn) because of sorting
        // Space: O(1) -- Because sorting usually doesn't take extra memory. However
        // it might be O(n), so it depends on the built-in sorting algorithm used.

        // if (s.length() != t.length()) return false;

        // char[] sChars = s.toCharArray();
        // char[] tChars = t.toCharArray();

        // Arrays.sort(sChars);
        // Arrays.sort(tChars);

        // return new String(sChars).equals(new String(tChars));
        /********************************************************** */
        // This will only work for small-case English charachters
        // Time: O(n)
        // Space: O(26) which equals O(1)

        // if (s.length() != t.length()) return false;

        // int[] count = new int[26]; // Array length is 26 because we deal only with
        // English charachters

        // for(int i = 0; i < s.length(); i++) {
        // count[s.charAt(i) - 'a']++;
        // count[t.charAt(i) - 'a']--;
        // }

        // for(int i : count) {
        // if(i != 0) return false;
        // }

        // return true;
        /********************************************************** */
        // This works for all types of chars -- Unicode chars
        // Time: O(n)
        // Space: O(# of unique unicode chars, around 2 Millions) which equals O(1)
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) != 0)
                return false;
        }

        return true;
    }
}
