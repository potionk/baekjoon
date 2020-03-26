package bj9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int available;
    static int size;
    static int[] chessField;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        available = 0;
        chessField = new int[size];
        dfs(0);
        System.out.println(available);
    }

    public static void dfs(int x) {
        if (x == size) {
            available++;
        } else {
            for (int i = 0; i < size; i++) {
                int temp = chessField[x];
                chessField[x] = i;
                if (isAvailable(x))
                    dfs(x + 1);
                chessField[x] = temp;
            }
        }
    }

    public static boolean isAvailable(int x) {
        for (int i = 0; i < x; i++) {
            if (chessField[i] == chessField[x] || Math.abs(chessField[i] - chessField[x]) == Math.abs(x - i))
                return false;
        }
        return true;
    }
}