package bj15651;

import java.io.*;

public class Main {
    static int[] data;
    static int n,m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        n = Integer.parseInt(testCase[0]);
        m = Integer.parseInt(testCase[1]);
        data = new int[m];
        print(0);
        bw.flush();
        bw.close();
        br.close();
    }
    static void print(int curIndex) throws IOException {
        if (curIndex == m) {
            for (int i = 0; i < m; i++) {
                bw.write(data[i]+"");
                if (i != m - 1) bw.write(" ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            data[curIndex] = i+1;
            print(curIndex + 1);
        }
    }
}
