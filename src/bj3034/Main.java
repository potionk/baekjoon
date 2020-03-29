package bj3034;

import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase = br.readLine().split(" ");
        int N= Integer.parseInt(testCase[0]);
        int W= Integer.parseInt(testCase[1]);
        int H= Integer.parseInt(testCase[2]);
        double diagonal=Math.sqrt(W*W+H*H);
        for(int i=0; i<N; i++){
            int input= Integer.parseInt(br.readLine());
            if(input<=diagonal)
                System.out.println("DA");
            else
                System.out.println("NE");
        }
    }
}