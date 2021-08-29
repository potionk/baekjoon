package bj10453;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] AB = br.readLine().split(" ");
            char[] A = AB[0].toCharArray();
            char[] B = AB[1].toCharArray();
            int count = 0;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] != B[i]) {
                    int nextIdx = i + 1;
                    char findTarget;
                    if (B[i] == 'a') {
                        findTarget = 'a';
                    } else {
                        findTarget = 'b';
                    }
                    while (A[nextIdx] != findTarget) {
                        nextIdx++;
                    }
                    for (int k = nextIdx; k >= i + 1; k--) {
                        swap(A, k, k - 1);
                        count++;
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.close();
    }

    public static void swap(char[] A, int a, int b) {
        char temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}