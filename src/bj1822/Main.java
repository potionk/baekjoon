package bj1822;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        br.readLine();
        Map<Integer, Boolean> map = new HashMap<>();
        String[] AStr = br.readLine().split(" ");
        int[] A = strArr2intArr(AStr);
        Arrays.sort(A);
        for (Integer s : A) {
            map.put(s, false);
        }
        String[] B = br.readLine().split(" ");
        int bCount = 0;
        for (String s : B) {
            int intS = Integer.parseInt(s);
            if (map.get(intS) != null) {
                map.put(intS, true);
                bCount++;
            }
        }
        bw.write(A.length - bCount+"\n");
        for (Integer s : A) {
            if (!map.get(s)) {
                bw.write(s + " ");
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
