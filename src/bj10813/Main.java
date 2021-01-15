package bj10813;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] tc = br.readLine().split(" ");
        int N = Integer.parseInt(tc[0]);
        int M = Integer.parseInt(tc[1]);
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < M; i++) {
            String[] cmd = br.readLine().split(" ");
            swap(arr, Integer.parseInt(cmd[0]), Integer.parseInt(cmd[1]));
        }
        for (int a : arr) {
            bw.write(a + " ");
        }
        bw.close();
        br.close();
    }

    public static void swap(int[] arr, int aIdx, int bIdx) {
        int temp = arr[bIdx - 1];
        arr[bIdx - 1] = arr[aIdx - 1];
        arr[aIdx - 1] = temp;
    }
}