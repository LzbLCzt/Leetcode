package dfs2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 2021-03-05 16:09
 */
public class leetcode306 {
    public static void main(String[] args) {
        leetcode306 leetcode306 = new leetcode306();
        boolean res = leetcode306.isAdditiveNumber("121474836472147483648");
        System.out.println(res);
    }


    public boolean isAdditiveNumber(String num) {
        List<Long> res = new ArrayList<>();
        return backtrack(num.toCharArray(), res, 0);
    }

    private boolean backtrack(char[] digit, List<Long> res, int index) {
        //边界条件判断，如果截取完了，并且res长度大于等于3，表示找到了一个组合。
        if (index == digit.length && res.size() >= 3) {
            return true;
        }
        for (int i = index; i < digit.length; i++) {
            //两位以上的数字不能以0开头
            if (digit[index] == '0' && i > index) { //此时num会以0开头，是无意义的
                break;
            }
            //截取字符串转化为数字
            long num = subDigit(digit, index, i + 1);
            //如果截取的数字大于int的最大值，则终止截取
            int size = res.size();
            //如果截取的数字大于res中前两个数字的和，说明这次截取的太大，直接终止，因为后面越截取越大
            if (size >= 2 && num > res.get(size - 1) + res.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == res.get(size - 1) + res.get(size - 2)) {
                //把数字num添加到集合res中
                res.add(num);
                //如果找到了就直接返回
                //*******这里就是为什么backtrack要有返回值的原因：保证符合条件的数字不被回溯掉
                //********res里面放四个数：a、b、c、d -》 c被加入res的前提是a + b = c，而c被删除（回溯)的前提是b + c ！= d，
                if (backtrack(digit, res, i + 1))   //**********
                    return true;
                //如果没找到，就会走回溯这一步，然后把上一步添加到集合res中的数字给移除掉
                res.remove(res.size() - 1);
            }
        }
        return false;
    }

    /*
    size:斐波那契元素数量
     */


    private long subDigit(char[] arr, int i, int j) {
        long num = 0;
        for (int i1 = i; i1 < j; i1++) {
            num = num * 10 + arr[i1] - '0';
        }
        return num;
    }

}
