package Exam.AiQiYi;//package Exam.AiQiYi;
//
//import Exam.Main;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
////荣耀第一题
//public class Main2 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        int total = Integer.parseInt(bf.readLine());
//        n = total;
//        arr = new int[n];
//        dfs(0);
//    }
//
//    static int n;
//    static int[] arr;
//    private static void dfs(int index) {
//        if (index == n){
//            show(arr);
//            return;
//        }
//        for (int i = 0; i < n; i++) {
//            arr[index] = i;
//            if (conflict(index)){
//                dfs(index+1);
//            }
//        }
//    }
//
//    private static boolean conflict(int index) {
//        for (int i = 0; i < index; i++) {
//            if (arr[index] == arr[0] || Math.abs(index-i) == Math.abs(arr[index] - arr[i])){
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private static void show(int[] arr) {
//        List<List<String>> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            List<String> temp = new ArrayList<>();
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int j = 0; j < n; j++) {
//                if (arr[i] == j){
//                    stringBuilder.append("Q");
//                }else {
//                    stringBuilder.append(".");
//                }
//            }
//            temp.add(stringBuilder.toString());
//            list.add(stringBuilder.toString());
//        }
//
//        for (String x : list) {
//
//        }
//    }
//
//
//}