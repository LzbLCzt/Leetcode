package Window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//荣耀第一题
public class Solution3 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        StringBuilder stringBuilder = new StringBuilder();
//        String str = "I am an 20-years  out--standing @ * -stu- dent";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c) || Character.isAlphabetic(c) || c == '-' || c == ' '){
                stringBuilder.append(c);
            }else {
                continue;
            }
        }
        String[] arr = stringBuilder.toString().split(" ");
//        System.out.println(Arrays.toString(arr));
        Deque<String> stack = new ArrayDeque<>();
        for (String s : arr) {
            if (s.length() < 1 || s == " "){
                continue;
            }
            if (s.contains("--")){
                String[] split = s.split("--");
                for (String x : split) {
                    if (x == "" || x == " "){
                        continue;
                    }
                    x = removeone(x);
//                    System.out.println("***" + x + "***");
                    stack.offerFirst(x);
                }
            }else {
                s = removeone(s);
//                System.out.println("***" + s + "***");
                stack.offerFirst(s);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()){
            ans.append(stack.pollFirst() + " ");
        }

        System.out.println(ans.toString().substring(0,ans.length() - 1));
    }

    private static String removeone(String str) {
        if (str.length() < 1){
            return "";
        }
        int l = 0;
        int r = str.length() - 1;
        while (str.charAt(l) == '-' || str.charAt(l) == ' '){
            l++;
        }
        while (str.charAt(r) == '-' || str.charAt(l) == ' '){
            r--;
        }
        return str.substring(l,r+1);
    }
}