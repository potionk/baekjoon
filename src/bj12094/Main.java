package bj12094;

import java.io.*;

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
            move(board, -1, i, 0, maxBlock, N);
        }
        bw.write(answer + "");
        br.close();
        bw.close();
    }

    // arrow : 0 left, 1 right, 2 top, 3 bottom
    public static void move(int[][] board, int beforeArrow, int arrow, int count, int maxBlock, int size) {
        if (count == 10) {
            answer = Math.max(answer, maxBlock);
        } else {
            boolean needNext;
            int[][] newBoard = new int[size][size];
            int[] nextIdx = new int[size];
            switch (arrow) {
                case 0:
                    for (int y = 0; y < size; y++) {
                        int before = -1;
                        for (int x = 0; x < size; x++) {
                            if (board[y][x] > 0) {
                                if (before == board[y][x]) {
                                    newBoard[y][nextIdx[y] - 1] = newBoard[y][nextIdx[y] - 1] * 2;
                                    maxBlock = Math.max(maxBlock, newBoard[y][nextIdx[y] - 1]);
                                    before = -1;
                                } else {
                                    newBoard[y][nextIdx[y]] = board[y][x];
                                    nextIdx[y]++;
                                    before = board[y][x];
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < size; i++) {
                        nextIdx[i] = size - 1;
                    }
                    for (int y = 0; y < size; y++) {
                        int before = -1;
                        for (int x = size - 1; x >= 0; x--) {
                            if (board[y][x] > 0) {
                                if (before == board[y][x]) {
                                    newBoard[y][nextIdx[y] + 1] = newBoard[y][nextIdx[y] + 1] * 2;
                                    maxBlock = Math.max(maxBlock, newBoard[y][nextIdx[y] + 1]);
                                    before = -1;
                                } else {
                                    newBoard[y][nextIdx[y]] = board[y][x];
                                    nextIdx[y]--;
                                    before = board[y][x];
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    for (int x = 0; x < size; x++) {
                        int before = -1;
                        for (int y = 0; y < size; y++) {
                            if (board[y][x] > 0) {
                                if (before == board[y][x]) {
                                    newBoard[nextIdx[x] - 1][x] = newBoard[nextIdx[x] - 1][x] * 2;
                                    maxBlock = Math.max(maxBlock, newBoard[nextIdx[x] - 1][x]);
                                    before = -1;
                                } else {
                                    newBoard[nextIdx[x]][x] = board[y][x];
                                    nextIdx[x]++;
                                    before = board[y][x];
                                }
                            }
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < size; i++) {
                        nextIdx[i] = size - 1;
                    }
                    for (int x = 0; x < size; x++) {
                        int before = -1;
                        for (int y = size - 1; y >= 0; y--) {
                            if (board[y][x] > 0) {
                                if (before == board[y][x]) {
                                    newBoard[nextIdx[x] + 1][x] = newBoard[nextIdx[x] + 1][x] * 2;
                                    maxBlock = Math.max(maxBlock, newBoard[nextIdx[x] + 1][x]);
                                    before = -1;
                                } else {
                                    newBoard[nextIdx[x]][x] = board[y][x];
                                    nextIdx[x]--;
                                    before = board[y][x];
                                }
                            }
                        }
                    }
                    break;
            }
            needNext = isNeedNext(arrow, beforeArrow, board, newBoard, size);
            if (answer != -1) {
                int t = answer;
                for (int i = 0; i < 10 - count; i++) {
                    t /= 2;
                }
                if (maxBlock <= t) {
                    return;
                }
            }
            for (int i = 0; i < 4; i++) {
                if (i == arrow) {
                    if (needNext) {
                        move(arrayCopy(newBoard, size), arrow, i, count + 1, maxBlock, size);
                    } else {
                        answer = Math.max(answer, maxBlock);
                    }
                } else {
                    move(arrayCopy(newBoard, size), arrow, i, count + 1, maxBlock, size);
                }
            }
        }
    }

    public static int[][] arrayCopy(int[][] src, int size) {
        int[][] newArray = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newArray[i][j] = src[i][j];
            }
        }
        return newArray;
    }

    public static boolean isNeedNext(int arrow, int beforeArrow, int[][] board, int[][] newBoard, int size) {
        boolean needNext = true;
        if (arrow == beforeArrow) {
            needNext = false;
            for (int i = 0; i < size; i++) {
                if (needNext) {
                    break;
                }
                for (int j = 0; j < size; j++) {
                    if (board[i][j] != newBoard[i][j]) {
                        needNext = true;
                        break;
                    }
                }
            }
        }
        return needNext;
    }
}