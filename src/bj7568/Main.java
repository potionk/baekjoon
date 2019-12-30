package bj7568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, String> dungchi = new HashMap<>();
        int count=Integer.parseInt(br.readLine());
        for(int i=0; i<count; i++){
            dungchi.put(i,1+" "+br.readLine());
        }
        for(int i=0; i<count; i++){
            String compare[]=dungchi.get(i).split(" ");
            for(int j=0; j<count; j++){
                if(i==j) continue;
                String target[]=dungchi.get(j).split(" ");
                if(Integer.parseInt(compare[1])>Integer.parseInt(target[1])&&Integer.parseInt(compare[2])>Integer.parseInt(target[2])){
                    int rank=Integer.parseInt(target[0])+1;
                    dungchi.put(j,rank+" "+target[1]+" "+target[2]);
                }
            }
        }
        for(int i=0; i<count; i++){
            String printTarget[]=dungchi.get(i).split(" ");
            System.out.println(printTarget[0]);
        }
    }
}