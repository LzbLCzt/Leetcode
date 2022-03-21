import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author shkstart
 * @create 2021-08-19 10:23
 */
public class Test {
    public static void main(String[] args) throws IOException {
        ////第一种输入方式
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(dp));
        }
        scanner.close();

        //对二维数据排序
        int[][] arr = {{5, 8}, {9, 8}, {4, 4}, {5, 2}};
        Arrays.sort(arr, new Comparator<int[]>(){
            public int compare(int a[], int b[]){
                if (a[0] == b[0]){
                    return b[1] - a[1];
                }else{
                    return b[0] - a[0];
                }
            }
        });
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        //第二种输入方式 -> 直接读取一行数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] params = br.readLine().trim().split(" ");


        br.close();
    }
}
