package bj2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static boolean[][] bfsIsVisited;
    static int xSize, ySize;
    static int[][] count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        xSize= Integer.parseInt(testCase[1]);
        ySize= Integer.parseInt(testCase[0]);
        graph=new int[ySize][xSize];
        count=new int[ySize][xSize];
        for(int i=0; i<ySize; i++){
            String input=br.readLine();
            for(int j=0; j<input.length(); j++){
                graph[i][j]= Integer.parseInt(input.charAt(j)+"");
            }
        }
        bfsIsVisited=new boolean[ySize][xSize];
        bfs(0,0);
        System.out.println(count[ySize-1][xSize-1]);
    }
    public static void bfs(int y, int x){
        LinkedList<XY> queue=new LinkedList<>();
        queue.add(new XY(x,y));
        bfsIsVisited[y][x]=true;
        count[y][x]=1;
        while(queue.size()!=0){
            XY next=queue.poll();
            x=next.getX();
            y=next.getY();
            if(!(next.y+1>=ySize)&&graph[y+1][x]==1&&!bfsIsVisited[y+1][x]){
                queue.add(new XY(x,y+1));
                bfsIsVisited[y+1][x]=true;
                count[y+1][x]=count[y][x]+1;
            }
            if(!(x+1>=xSize)&&graph[y][x+1]==1&&!bfsIsVisited[y][x+1]){
                queue.add(new XY(x+1,y));
                bfsIsVisited[y][x+1]=true;
                count[y][x+1]=count[y][x]+1;
            }
            if(!(y-1<0)&&graph[y-1][x]==1&&!bfsIsVisited[y-1][x]){
                queue.add(new XY(x,y-1));
                bfsIsVisited[y-1][x]=true;
                count[y-1][x]=count[y][x]+1;
            }
            if(!(x-1<0)&&graph[y][x-1]==1&&!bfsIsVisited[y][x-1]){
                queue.add(new XY(x-1,y));
                bfsIsVisited[y][x-1]=true;
                count[y][x-1]=count[y][x]+1;
            }
        }
    }
}
class XY{
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