package bj9663;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] chessField;
    static int size, queen, available;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        queen = size;
        chessField = new boolean[size][size];
        available=0;

        for (int i = 0; i < size; i++) {
            ArrayList<XY> list=calAttRange(i,0);
            for(int j=0; j<list.size(); j++){
                XY xy=list.get(j);
                chessField[xy.getY()][xy.getX()]=true;
            }
            dfs(i, 0, 1);
            for(int j=0; j<list.size(); j++){
                XY xy=list.get(j);
                chessField[xy.getY()][xy.getX()]=false;
            }
        }
        System.out.println(available);
    }

    public static void dfs(int x, int y, int count) {
        for (int i = 0; i < size; i++) {
            if(count==size-1){
                if(!chessField[y+1][i]){
                    available++;
                }
                return;
            }
            else if(!chessField[y+1][i]){
                ArrayList<XY> list=calAttRange(i,y+1);
                for(int j=0; j<list.size(); j++){
                    XY xy=list.get(j);
                    chessField[xy.getY()][xy.getX()]=true;
                }
                dfs(i, y+1, count+1);
                for(int j=0; j<list.size(); j++){
                    XY xy=list.get(j);
                    chessField[xy.getY()][xy.getX()]=false;
                }
            }

        }
    }

    public static ArrayList<XY> calAttRange(int x, int y) {
        ArrayList<XY> list = new ArrayList<>();
        if(!chessField[y][x])
            list.add(new XY(y,x));
        for (int j = 0; j < size; j++) {
            if(!chessField[y][j]&&j!=x)
                list.add(new XY(j, y));
            if(!chessField[j][x]&&j!=y)
                list.add(new XY(x, j));
        }
        int cursorX, cursorY;
        int[] nextX = {-1, 1, -1, 1};
        int[] nextY = {-1, -1, 1, 1};
        for (int i = 0; i < 4; i++) {
            cursorX = x;
            cursorY = y;
            while (true) {
                if (cursorX + nextX[i] >= 0 && cursorX + nextX[i] < size && cursorY + nextY[i] >= 0 && cursorY + nextY[i] < size){
                    if(!chessField[cursorY + nextY[i]][cursorX + nextX[i]]){
                        list.add(new XY(cursorX + nextX[i], cursorY + nextY[i]));
                    }
                    cursorX += nextX[i];
                    cursorY += nextY[i];
                }
                else
                    break;
            }
        }
        return list;
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