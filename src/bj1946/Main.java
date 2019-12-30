package bj1946;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c1=Integer.parseInt(br.readLine());
        for(int i=0; i<c1; i++) {
            int c2=Integer.parseInt(br.readLine());
            int result=c2;
            int[] s=new int[c2]; //심사
            int[] m=new int[c2]; //면접
            for(int j=0; j<c2; j++){
                String input[] = br.readLine().split(" ");
                s[Integer.parseInt(input[0])-1]=Integer.parseInt(input[1]);
            }
            for(int j=0; j<c2; j++){
                for(int k=j-1; k>-1; k--){
                    if(s[j]>s[k]){
                        --result;
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }
}