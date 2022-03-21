package doublePointer2;

import java.util.*;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode267 {
    public static void main(String[] args) {
        leetcode267 leetcode267 = new leetcode267();
        List<String> ans = leetcode267.generatePalindromes("aabbcc");
        System.out.println(ans);
    }

    List<String> res;
    char c = '0';
    boolean[] isVisited;
    public List<String> generatePalindromes(String s) {
        res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        if(!canGeneratePalindromes(s.toCharArray(), map)){
            return new ArrayList<>();
        }
        String halfStr = buildHalf(map);
        isVisited = new boolean[halfStr.length()];
        backTrack(halfStr.toCharArray(), 0, new StringBuilder());
        return res;
    }

    private void backTrack(char[] arr, int index, StringBuilder path) {
        if (index >= arr.length){
            String newStr = path.toString() + (c == '0'? "": "" + c) + new StringBuilder(path).reverse();
            res.add(newStr);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i] && !isVisited[i - 1]){
                continue;
            }
            if (!isVisited[i]){
                isVisited[i] = true;
                path.append(arr[i]);
                backTrack(arr, index + 1, path);
                isVisited[i] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    private String buildHalf(Map<Character, Integer> map) {
        StringBuilder res = new StringBuilder();
        for(char key: map.keySet()){
            int value = map.get(key);
            if (value % 2 == 1) c = key;
            for (int i = 0; i < value / 2; i++) {
                res.append(key);
            }
        }
        return new String(res);
    }

    private boolean canGeneratePalindromes(char[] arr, Map<Character, Integer> map) {
        int count = 0;
        for (char c: arr){
            map.put(c,map.getOrDefault(c,0) + 1);
            int times = map.get(c);
            count = times % 2 == 0? count - 1: count + 1;
        }
        return count <= 1;
    }
}
