package bj5704;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Set<Character> alphabetSet;
        String tc;
        while (!(tc = br.readLine()).equals("*")) {
            int tcLen = tc.length();
            alphabetSet = new HashSet<>();
            for (int i = 0; i < tcLen; i++) {
                if(tc.charAt(i)!=' '){
                    alphabetSet.add(tc.charAt(i));
                }
            }
            if (alphabetSet.size() == 26) {
                bw.write("Y\n");
            } else {
                bw.write("N\n");
            }
        }
        br.close();
        bw.close();
    }
}