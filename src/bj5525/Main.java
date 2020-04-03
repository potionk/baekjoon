package bj5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int testCaseSize = Integer.parseInt(br.readLine());
        char[] testCase = br.readLine().toCharArray();
        int count = 0;
        for (int i = 0; i < testCaseSize - N; i++) {
            if (testCase[i] == 'I' && testCase[i + 1] == 'O') {
                int ioiCount = 0;
                if(i+2<testCaseSize){
                    while (testCase[i + 1] == 'O' && testCase[i + 2] == 'I') {
                        i += 2;
                        ioiCount++;
                        if (ioiCount >= N)
                            count++;
                        if(i+2>=testCaseSize){
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }
}