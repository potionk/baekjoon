package bj2239;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] sudoku;
    static List<XY> blankList;
    static Map<Integer, Integer>[] yMap, xMap, sections;
    static boolean finish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        blankList = new ArrayList<>();
        yMap = new Map[9];
        xMap = new Map[9];
        sections = new Map[9];
        for (int i = 0; i < 9; i++) {
            yMap[i] = new HashMap<>();
            xMap[i] = new HashMap<>();
            sections[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) { // y
            String readLine = br.readLine();
            for (int j = 0; j < 9; j++) { // x
                int data = readLine.charAt(j) - '0';
                if (data == 0)
                    blankList.add(new XY(j, i));
                else {
                    yMap[i].put(data, 1);
                    xMap[j].put(data, 1);
                    if (i < 3) {
                        if (j < 3)
                            sections[0].put(data, 1);
                        else if (j < 6)
                            sections[1].put(data, 1);
                        else
                            sections[2].put(data, 1);
                    } else if (i < 6) {
                        if (j < 3)
                            sections[3].put(data, 1);
                        else if (j < 6)
                            sections[4].put(data, 1);
                        else
                            sections[5].put(data, 1);
                    } else {
                        if (j < 3)
                            sections[6].put(data, 1);
                        else if (j < 6)
                            sections[7].put(data, 1);
                        else
                            sections[8].put(data, 1);
                    }
                }
                sudoku[i][j] = data;
            }
        }
        dfs(0);

    }

    public static void dfs(int index) {
        if (finish)
            return;
        if (index == blankList.size()) {
            boolean state = false;
            for (int i = 0; i < 9; i++) {
                if (yMap[i].size() != 9) {
                    state = true;
                    break;
                }
            }
            if (!state) {
                for (int i = 0; i < 9; i++) {
                    if (xMap[i].size() != 9) {
                        state = true;
                        break;
                    }
                }
            }
            if (!state) {
                for (int y = 0; y < 9; y++) {
                    for (int x = 0; x < 9; x++) {
                        System.out.print(sudoku[y][x]);
                    }
                    System.out.println();
                }
            }
            finish = true;
            return;
        }
        XY cur = blankList.get(index);
        int curX = cur.getX();
        int curY = cur.getY();
        int section;
        if (curY < 3) {
            if (curX < 3)
                section = 0;
            else if (curX < 6)
                section = 1;
            else
                section = 2;
        } else if (curY < 6) {
            if (curX < 3)
                section = 3;
            else if (curX < 6)
                section = 4;
            else
                section = 5;
        } else {
            if (curX < 3)
                section = 6;
            else if (curX < 6)
                section = 7;
            else
                section = 8;
        }
        HashMap<Integer, Integer> checkX = new HashMap<>();
        HashMap<Integer, Integer> checkY = new HashMap<>();
        ArrayList<Integer> availableList = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (yMap[curY].get(i) == null)
                checkX.put(i, 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (checkX.get(i) != null && xMap[curX].get(i) == null)
                checkY.put(i, 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (checkY.get(i) != null && sections[section].get(i) == null)
                availableList.add(i);
        }
        if (availableList.size() == 0)
            return;
        for (int availItem : availableList) {
            xMap[curX].put(availItem, 1);
            yMap[curY].put(availItem, 1);
            sections[section].put(availItem, 1);
            sudoku[curY][curX] = availItem;
            dfs(index + 1);
            xMap[curX].remove(availItem);
            yMap[curY].remove(availItem);
            sections[section].remove(availItem);
            sudoku[curY][curX] = 0;
        }
    }
}

class XY {
    int x;
    int y;

    public XY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
