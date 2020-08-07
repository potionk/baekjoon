package bj1822;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        Set<Integer> checkDup = new HashSet<>();
        String[] AStr = br.readLine().split(" ");
        int[] A = strArr2intArr(AStr);
        Arrays.sort(A);
        for (Integer s : A) {
            checkDup.add(s);
        }
        String[] B = br.readLine().split(" ");
        for (String s : B) {
            checkDup.remove(Integer.parseInt(s));
        }
        bw.write(checkDup.size() + "\n");
        for (int value : A) {
            if (checkDup.contains(value)) {
                bw.write(value + " ");
            }
        }
        bw.flush();
    }

    public static int[] strArr2intArr(String[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = Integer.parseInt(arr[i]);
        }
        return result;
    }
}
