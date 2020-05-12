package kakao.four;

import java.util.*;

class Solution {
    static int[][] raceBoard;
    static boolean[][] dfsIsVisited;
    static ArrayList<Integer> list=new ArrayList<>();

    public static void main(String[] args) {
        Solution solution=new Solution();
//        int[][] input={{0,0,0},{0,0,0},{0,0,0}};
        int[][] input={{0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 0, 1}, {1, 0, 0, 0}};
        System.out.println(solution.solution(input));
    }

    public int solution(int[][] board) {
        raceBoard = board;
        dfsIsVisited=new boolean[raceBoard.length][raceBoard[0].length];
        dfsIsVisited[0][0] = true;
        dfs(0, 0, true, 100);
        System.out.println(list);
        Collections.sort(list);
        int answer = list.get(0);
        return answer;
    }

    public static void dfs(int y, int x, boolean arrow, int curCost) { // arrow true이면 가로 false이면 세로
        if(y==raceBoard.length-1 && x==raceBoard[0].length-1)
            list.add(curCost);
        if (!(y - 1 < 0) && raceBoard[y - 1][x] == 0 && !dfsIsVisited[y - 1][x]) {
            int cost = 0;
            if (!arrow || (x == 0 && y == 0))
                cost = 100;
            else
                cost = 500;
            curCost += cost;
            dfsIsVisited[y-1][x] = true;
            dfs(y - 1, x, false, curCost);
            dfsIsVisited[y-1][x] = false;
            curCost -= cost;
        }
        if (!(y + 1 >= raceBoard.length) && raceBoard[y + 1][x] == 0 && !dfsIsVisited[y + 1][x]) {
            int cost = 0;
            if (!arrow || (x == 0 && y == 0))
                cost = 100;
            else
                cost = 500;
            curCost += cost;
            dfsIsVisited[y+1][x] = true;
            dfs(y + 1, x, false, curCost);
            dfsIsVisited[y+1][x] = false;
            curCost -= cost;
        }
        if (!(x - 1 < 0) && raceBoard[y][x - 1] == 0 && !dfsIsVisited[y][x - 1]) {
            int cost = 0;
            if (arrow || (x == 0 && y == 0))
                cost = 100;
            else
                cost = 500;
            curCost += cost;
            dfsIsVisited[y][x-1] = true;
            dfs(y, x - 1, true, curCost);
            dfsIsVisited[y][x-1] = false;
            curCost -= cost;
        }
        if (!(x + 1 >= raceBoard[0].length) && raceBoard[y][x + 1] == 0 && !dfsIsVisited[y][x + 1]){
            int cost = 0;
            if (arrow || (x == 0 && y == 0))
                cost = 100;
            else
                cost = 500;
            curCost += cost;
            dfsIsVisited[y][x+1] = true;
            dfs(y, x + 1, true, curCost);
            dfsIsVisited[y][x+1] = false;
            curCost -= cost;
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