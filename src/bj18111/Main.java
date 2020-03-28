package bj18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, M, blocks;
        int resultT=Integer.MAX_VALUE, resultB=-1;
        String[] testCase=br.readLine().split(" ");
        N= Integer.parseInt(testCase[0]);
        M= Integer.parseInt(testCase[1]);
        blocks= Integer.parseInt(testCase[2]);
        int[][] map=new int[N][M];
        Result[][] result=new Result[N][M];
        for(int i=0; i<N; i++){
            String[] input=br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j]= Integer.parseInt(input[j]);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int timeResult=0;
                int tempBlocks=blocks;
                for(int findY=0; findY<N; findY++){
                    for(int findX=0; findX<M; findX++){
                        if(findY==i&&findX==j)
                            continue;
                        if(map[findY][findX]>map[i][j]){
                            timeResult+=(map[findY][findX]-map[i][j])*2;
                            tempBlocks+=map[findY][findX]-map[i][j];
                        } else if(map[findY][findX]<map[i][j]&&tempBlocks>0){
                            timeResult+=(map[i][j]-map[findY][findX]);
                            tempBlocks-=(map[i][j]-map[findY][findX]);
                        }
                    }
                }
                result[i][j]=new Result(timeResult, map[i][j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(resultT>=result[i][j].getTime()){
                    resultT=result[i][j].getTime();
                    resultB=Math.max(resultB, result[i][j].getHeight());
                }
            }
        }
        System.out.println(resultT+" "+resultB);
    }
}

class Result{
    int time;
    int height;

    public int getTime() {
        return time;
    }

    public int getHeight() {
        return height;
    }
    public Result(int time, int height){
        this.time=time;
        this.height=height;
    }
}