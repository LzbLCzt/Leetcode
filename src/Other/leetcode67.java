package Other;

/**
 * @author shkstart
 * @create 2021-04-01 22:41
 */
public class leetcode67 {
    public static void main(String[] args) {
        leetcode67 leetcode67 = new leetcode67();
        String a = "11";
        String b = "1";
        String res = leetcode67.addBinary(a, b);
        System.out.println(res);

    }

    public String addBinary(String a, String b) {
        int flag = 0, i = a.length() - 1, j = b.length() - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i >= 0 || j >= 0 || flag == 1){
            int num1 = i < 0? 0 : Integer.parseInt(a.substring(i,i+1));
            int num2 = j < 0? 0 : Integer.parseInt(b.substring(j,j+1));
            if (num1 + num2 + flag >= 2){
                stringBuilder.append((num1 + num2 + flag) % 2);
                flag = 1;
            }else{
                stringBuilder.append(num1 + num2 + flag);
                flag = 0;
            }
            --i;
            --j;
        }

        return stringBuilder.reverse().toString();
    }
}
