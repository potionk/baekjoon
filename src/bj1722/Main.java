package bj1722;

import java.io.*;

public class Main {
    static boolean[] isVisited;
    static int[] data;
    static int n, m;
    static StringBuilder sb;
    static int count, targetIndex;
    static String target;
    static boolean isFinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        n = testCase;
        m = testCase;
        count = 1;
        sb = new StringBuilder();
        isVisited = new boolean[n];
        data = new int[m];
        String cmdStr=br.readLine();
        String[] cmd = cmdStr.split(" ");
        if (cmd[0].equals("1")) {
            targetIndex= Integer.parseInt(cmd[1]);
            print(0,1);
        } else {
            target=cmdStr.substring(2);
            print(0,2);
        }
    }

    static void print(int curIndex, int mode) {
        if(isFinish)
            return;
        if (curIndex == m) {
            for (int i = 0; i < m; i++) {
                sb.append(data[i] + " ");
            }
            if(mode==2&&sb.toString().equals(target+" ")){
                System.out.println(count);
                isFinish=true;
                return;
            } else if(mode==1&&count==targetIndex){
                System.out.println(sb.toString());
                isFinish=true;
                return;
            } else {
                sb = new StringBuilder();
                count++;
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isVisited[i])
                continue;
            isVisited[i] = true;
            data[curIndex] = i + 1;
            print(curIndex + 1, mode);
            isVisited[i] = false;
        }
    }
}
