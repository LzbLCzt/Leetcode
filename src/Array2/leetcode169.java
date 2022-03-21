package Array2;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode169 {
    public static void main(String[] args) {
        
    }


    //方法：Boyer-Moore 投票算法
    //要求：时间：O（n），空间：O（1）
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0){
                candidate = num;
            }

            count += (num == candidate)? 1 : -1;
        }

        return candidate;
    }
}
