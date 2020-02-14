package bj7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static int count;
    static int xSize, ySize;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        xSize= Integer.parseInt(testCase[0]);
        ySize= Integer.parseInt(testCase[1]);
        ArrayList<XY> list=new ArrayList<>();
        count=0;
        graph=new int[ySize][xSize];
        for(int i=0; i<ySize; i++){
            String[] input=br.readLine().split(" ");
            for(int j=0; j<input.length; j++){
                graph[i][j]= Integer.parseInt(input[j]);
                if (graph[i][j] == 1){
                    list.add(new XY(j,i));
                }

            }
        }
        bfs(list);
        for(int i=0; i<ySize; i++){
            for(int j=0; j<xSize; j++){
                if(graph[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
    public static void bfs(ArrayList<XY> list){
        LinkedList<XY> queue = new LinkedList<>(list);
        boolean isContinue=true;
        while(isContinue){
            isContinue=false;
            int beforeQueueSize=queue.size();
            for(int i=0; i<beforeQueueSize; i++){
                XY next=queue.poll();
                int x=next.getX();
                int y=next.getY();
                if(!(y+1>=ySize)&&graph[y+1][x]==0){
                    queue.add(new XY(x,y+1));
                    graph[y+1][x]=1;
                    isContinue=true;
                }
                if(!(x+1>=xSize)&&graph[y][x+1]==0){
                    queue.add(new XY(x+1,y));
                    graph[y][x+1]=1;
                    isContinue=true;
                }
                if(!(y-1<0)&&graph[y-1][x]==0){
                    queue.add(new XY(x,y-1));
                    graph[y-1][x]=1;
                    isContinue=true;
                }
                if(!(x-1<0)&&graph[y][x-1]==0){
                    queue.add(new XY(x-1,y));
                    graph[y][x-1]=1;
                    isContinue=true;
                }
            }
            if(isContinue)
                count++;
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