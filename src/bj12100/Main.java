package bj12100;

import java.io.*;
import java.util.Arrays;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        int maxBlock = -1;
        for (int i = 0; i < N; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(readLine[j]);
                maxBlock = Math.max(maxBlock, board[i][j]);
            }
        }
        answer = -1;
        for (int i = 0; i < 4; i++) {
            move(board, i, 0, maxBlock, N);
        }
        bw.write(answer + "");
        br.close();
        bw.close();
    }

    // arrow : 0 left, 1 right, 2 top, 3 bottom
    public static void move(int[][] board, int arrow, int count, int maxBlock, int size) {
        if (count == 5) {
            answer = Math.max(answer, maxBlock);
        } else {
            int[][] newBoard = new int[size][size];
            switch (arrow) {
                case 0 -> {
                    int[] nextIdx = new int[size];
                    for (int y = 0; y < size; y++) {
                        for (int x = 0; x < size; x++) {
                            if (board[y][x] > 0) {
                                boolean exist = false;
                                for (int next = x + 1; next < size; next++) {
                                    if (board[y][next] > 0) {
                                        if (board[y][next] == board[y][x]) {
                                            newBoard[y][nextIdx[y]] = board[y][x] * 2;
                                            maxBlock = Math.max(maxBlock, newBoard[y][nextIdx[y]]);
                                            nextIdx[y]++;
                                            exist = true;
                                            x = next;
                                        }
                                        break;
                                    }
                                }
                                if (!exist) {
                                    newBoard[y][nextIdx[y]] = board[y][x];
                                    nextIdx[y]++;
                                }
                            }
                        }
                    }
                }
                case 1 -> {
                    int[] nextIdx = new int[size];
                    for (int i = 0; i < size; i++) {
                        nextIdx[i] = size - 1;
                    }
                    for (int y = 0; y < size; y++) {
                        for (int x = size - 1; x >= 0; x--) {
                            if (board[y][x] > 0) {
                                boolean exist = false;
                                for (int next = x - 1; next >= 0; next--) {
                                    if (board[y][next] > 0) {
                                        if (board[y][next] == board[y][x]) {
                                            newBoard[y][nextIdx[y]] = board[y][x] * 2;
                                            maxBlock = Math.max(maxBlock, newBoard[y][nextIdx[y]]);
                                            nextIdx[y]--;
                                            exist = true;
                                            x = next;
                                        }
                                        break;
                                    }
                                }
                                if (!exist) {
                                    newBoard[y][nextIdx[y]] = board[y][x];
                                    nextIdx[y]--;
                                }
                            }
                        }
                    }
                }
                case 2 -> {
                    int[] nextIdx = new int[size];
                    for (int x = 0; x < size; x++) {
                        for (int y = 0; y < size; y++) {
                            if (board[y][x] > 0) {
                                boolean exist = false;
                                for (int next = y + 1; next < size; next++) {
                                    if (board[next][x] > 0) {
                                        if (board[next][x] == board[y][x]) {
                                            newBoard[nextIdx[x]][x] = board[y][x] * 2;
                                            maxBlock = Math.max(maxBlock, newBoard[nextIdx[x]][x]);
                                            nextIdx[x]++;
                                            exist = true;
                                            y = next;
                                        }
                                        break;
                                    }
                                }
                                if (!exist) {
                                    newBoard[nextIdx[x]][x] = board[y][x];
                                    nextIdx[x]++;
                                }
                            }
                        }
                    }
                }
                case 3 -> {
                    int[] nextIdx = new int[size];
                    for (int i = 0; i < size; i++) {
                        nextIdx[i] = size - 1;
                    }
                    for (int x = 0; x < size; x++) {
                        for (int y = size - 1; y >= 0; y--) {
                            if (board[y][x] > 0) {
                                boolean exist = false;
                                for (int next = y - 1; next >= 0; next--) {
                                    if (board[next][x] > 0) {
                                        if (board[next][x] == board[y][x]) {
                                            newBoard[nextIdx[x]][x] = board[y][x] * 2;
                                            maxBlock = Math.max(maxBlock, newBoard[nextIdx[x]][x]);
                                            nextIdx[x]--;
                                            exist = true;
                                            y = next;
                                        }
                                        break;
                                    }
                                }
                                if (!exist) {
                                    newBoard[nextIdx[x]][x] = board[y][x];
                                    nextIdx[x]--;
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                move(arrayCopy(newBoard), i, count + 1, maxBlock, size);
            }
        }
    }

    public static int[][] arrayCopy(int[][] src) {
        return Arrays.stream(src).map(int[]::clone).toArray(int[][]::new);
    }
}
