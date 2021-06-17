package bj16401;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] MN = br.readLine().split(" ");
        int M = Integer.parseInt(MN[0]);
        int[] snack = strArrToIntArr(br.readLine().split(" "));
        int low = 1, high = -1, result = 0;
        for (int i : snack) {
            high = Math.max(i, high);
        }
        while (low <= high) {
            int mid = ((high + low) / 2);
            int count = 0;
            for (int s : snack) {
                if (count >= M) {
                    break;
                }
                count += s / mid;
            }
            if (count >= M) {
                result = Math.max(result, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }

    public static int[] strArrToIntArr(String[] arr) {
        int[] intArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }
}
