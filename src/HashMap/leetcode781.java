package HashMap;

import java.util.HashMap;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode781 {
    public static void main(String[] args) {
        leetcode781 leetcode781 = new leetcode781();
        int[] answers = {1, 1, 2};
        System.out.println(leetcode781.numRabbits(answers));
    }

    public int numRabbits(int[] answers) {
        if(answers.length < 1) return 0;

        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = answers.length;

        for (int i = 0; i < n; i++) {
            if(!map.containsKey(answers[i])){
                map.put(answers[i], 1);
                ans += answers[i] + 1;
            }else{
                Integer value = map.get(answers[i]);
                if(value == answers[i] + 1){
                    map.put(answers[i], 1);
                    ans += answers[i] + 1;
                }else{
                    map.put(answers[i] ,value + 1);
                }
            }
        }

        return ans;
    }
}
