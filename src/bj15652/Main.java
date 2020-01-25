package bj15652;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int[] data;
    static int n,m;
    static Map<String, Integer> isPrinted;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase=br.readLine().split(" ");
        n = Integer.parseInt(testCase[0]);
        m = Integer.parseInt(testCase[1]);
        isPrinted=new HashMap<>();
        data = new int[m];
        print(0);
        bw.flush();
        bw.close();
        br.close();
    }
    static void print(int curIndex) throws IOException {
        if (curIndex == m) {
            StringBuilder sb=new StringBuilder();
            char[] compareTarget=new char[m];
            for (int i = 0; i < m; i++) {
                compareTarget[i]=(char)data[i];
                sb.append(data[i]+"");
                if (i != m - 1)
                    sb.append(" ");
            }
            Arrays.sort(compareTarget);
            String ctStr=String.valueOf(compareTarget);
            if(isPrinted.get(ctStr)==null){
                bw.write(sb.toString()+"");
                bw.write("\n");
                isPrinted.put(ctStr,1);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            data[curIndex] = i+1;
            print(curIndex + 1);
        }
    }
}
