package Other2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode49 {
    public static void main(String[] args) {
        leetcode49 leetcode49 = new leetcode49();
        List<List<String>> ans = leetcode49.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(ans);
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                int index = str.charAt(i) - 'a';
                arr[index]++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (arr[i] != 0){
                    sb.append(arr[i]);
                    sb.append(i + 'a');
                }
            }
            String key = sb.toString();
            List<String> values = map.getOrDefault(key, new ArrayList<>());
            values.add(str);
            map.put(key, values);
        }
        for (List<String> value : map.values()) {
            res.add(value);
        }
        return res;
    }
}
