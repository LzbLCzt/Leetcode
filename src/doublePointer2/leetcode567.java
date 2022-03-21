package doublePointer2;

public class leetcode567 {
    public static void main(String[] args) {
        leetcode567 leetcode567 = new leetcode567();
        System.out.println(leetcode567.checkInclusion("abno", "eidbaooo"));
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            ++cnt[s2.charAt(i) - 'a'];
            --cnt[s1.charAt(i) - 'a'];
        }
        int diff = 0;
        for (int x : cnt) {
            diff += x != 0? 1: 0;
        }
        if (diff == 0) return true;
        for (int r = n; r < m; r++) {
            int x = s2.charAt(r) - 'a', y = s2.charAt(r - n) - 'a';
            if (cnt[x] == 0) diff++;
            else if (cnt[x] == -1) diff--;
            ++cnt[x];
            if (cnt[y] == 0) diff++;
            else if (cnt[y] == 1) diff--;
            --cnt[y];
            if (diff == 0) return true;
        }
        return false;
    }
}
