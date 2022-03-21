package ali;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shkstart
 * @create 2021-03-27 11:00
 */
public class Main2 {

    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str2 = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(str2.substring(j,j+1));
            }
        }

        String str3 = br.readLine();
        int k = Integer.parseInt(str3);
        int[][] elements = new int[k][2];
        for (int i = 0; i < k; i++) {
            String[] str4 = br.readLine().split(" ");
            elements[i][0] = Integer.parseInt(str4[0])-1;
            elements[i][1] = Integer.parseInt(str4[1])- 1;
        }


    }



}

