package ali;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author shkstart
 * @create 2021-03-27 11:00
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);
        int k = Integer.parseInt(str1[1]);

        String[] str2 = br.readLine().split(" ");
        int[] arr = new int[str2.length];
        for (int i = 0; i < str2.length; i++) {
            arr[i] = Integer.parseInt(str2[i]);
        }


    }


}

