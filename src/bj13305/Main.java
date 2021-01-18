package bj13305;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String[] distanceArrStr = br.readLine().split(" ");
        long[] distanceArr = strArr2IntArr(distanceArrStr);
        long[] cumDistance = new long[N - 1];
        cumDistance[N - 2] = distanceArr[N - 2];
        if (N >= 3) {
            for (int i = N - 3; i >= 0; i--) {
                cumDistance[i] = cumDistance[i + 1] + distanceArr[i];
            }
        }
        String[] priceArrStr = br.readLine().split(" ");
        long[] priceArr = strArr2IntArr(priceArrStr);
        long price = priceArr[0] * cumDistance[0]; // 처음 주유소에서 다 사둠
        long before = priceArr[0];
        for (int i = 1; i < N - 1; i++) {
            if (price > price - before * cumDistance[i] + priceArr[i] * cumDistance[i]) {
                price = price - before * cumDistance[i] + priceArr[i] * cumDistance[i];
                before = priceArr[i];
            }
        }
        bw.write(price + "");
        br.close();
        bw.close();
    }

    public static long[] strArr2IntArr(String[] strArr) {
        int len = strArr.length;
        long[] longArr = new long[len];
        for (int i = 0; i < len; i++) {
            longArr[i] = Long.parseLong(strArr[i]);
        }
        return longArr;
    }
}
