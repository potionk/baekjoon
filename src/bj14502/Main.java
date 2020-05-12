package bj14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] lab;
    static boolean[][] dfsIsVisited;
    static int xSize, ySize;
    static int curVirus;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        ySize = Integer.parseInt(size[0]);
        xSize = Integer.parseInt(size[1]);
        lab = new int[ySize][xSize];
        int[][] testCase=new int[ySize][xSize];
        dfsIsVisited = new boolean[ySize][xSize];
        List<XY> blankCor=new ArrayList<>();
        List<XY> virusCor=new ArrayList<>();
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        for (int i = 0; i < ySize; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < xSize; j++) {
                int tc=Integer.parseInt(input[j]);
                if(tc==0)
                    blankCor.add(new XY(j, i));
                else if(tc==2)
                    virusCor.add(new XY(j, i));
                testCase[i][j] = tc;
            }
        }
        int safePlace=blankCor.size();
        int maxSafePlace=Integer.MIN_VALUE;
        Object[] blankCorArr=blankCor.toArray();
        Object[] virusCorArr=virusCor.toArray();
        int blackCorSize=blankCor.size();
        for(int i=0; i<blackCorSize-2; i++){
            XY a= (XY) blankCorArr[i];
            for(int j=i+1; j<blackCorSize-1; j++){
                XY b= (XY) blankCorArr[j];
                for(int k=j+1; k<blackCorSize; k++){
                    dfsIsVisited = new boolean[ySize][xSize];
                    lab= arrayCopy(testCase);
                    XY c= (XY) blankCorArr[k];
                    lab[a.getY()][a.getX()]=1;
                    lab[b.getY()][b.getX()]=1;
                    lab[c.getY()][c.getX()]=1;
                    for(int l=0; l<virusCor.size(); l++){
                        XY curVirus=(XY)virusCorArr[l];
                        dfs(curVirus.getY(), curVirus.getX());
                    }
                    int curSafePlace=safePlace;
                    curSafePlace-=curVirus;
                    curVirus=0;
                    maxSafePlace=Math.max(curSafePlace, maxSafePlace);
                }
            }
        }
        System.out.println(maxSafePlace-3);
    }

    public static void dfs(int y, int x) {
        dfsIsVisited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            if (!(x + xArrow[i] >= xSize) && !(x + xArrow[i] < 0) && !(y + yArrow[i] >= ySize) && !(y + yArrow[i] < 0) && lab[y + yArrow[i]][x + xArrow[i]] == 0 && !dfsIsVisited[y + yArrow[i]][x + xArrow[i]]){
                curVirus++;
                dfs(y + yArrow[i], x + xArrow[i]);
            }
        }
    }

    public static int[][] arrayCopy(int[][] original) {
        int[][] result = new int[original.length][original[0].length];
        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
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