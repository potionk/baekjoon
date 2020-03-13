package bj14889;

import java.io.*;
import java.util.Stack;

public class Main {
    static int size;
    static int[][] stat;
    static boolean[] isVisited;
    static int minScoreGap;
    static Stack<Integer> indexStack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        stat = new int[size][size];
        isVisited = new boolean[size];
        indexStack = new Stack<>();
        minScoreGap=Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            String[] readLine = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                stat[i][j] = Integer.parseInt(readLine[j]);
            }
        }
        dfs(0, 1, 0);
        System.out.println(minScoreGap);
    }

    public static void dfs(int index, int count, int result) {
        if (count <= size / 2) {
            isVisited[index] = true;
            indexStack.push(index);
            if (count > 1) {
                for (int s = 0; s < indexStack.size() - 1; s++) {
                    result += stat[indexStack.get(s)][indexStack.peek()];
                    result += stat[indexStack.peek()][indexStack.get(s)];
                }
            }
            if (count + 1 <= size / 2) {
                for (int i = index + 1; i < size; i++) {
                    dfs(i, count + 1, result);
                }
            } else {
                int teamStartScore=result;
                int teamLinkScore=0;
                boolean[] isLinkTeam=new boolean[size];
                for(int i=0; i<indexStack.size(); i++){
                    isLinkTeam[indexStack.get(i)]=true;
                }
                int[] linkTeam=new int[size/2];
                int idx=0;
                for(int i=0; i<size; i++){
                    if(!isLinkTeam[i])
                        linkTeam[idx++]=i;
                }
                for(int i=0; i<linkTeam.length-1; i++){
                    for(int j=i+1; j<linkTeam.length; j++){
                        teamLinkScore+=stat[linkTeam[i]][linkTeam[j]];
                        teamLinkScore+=stat[linkTeam[j]][linkTeam[i]];
                    }
                }
                minScoreGap=Math.min(minScoreGap,Math.abs(teamLinkScore-teamStartScore));
            }
            isVisited[index] = false;
            indexStack.pop();
        }
    }
}
