package bj17219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase= br.readLine().split(" ");
        Map<String, String> database= new HashMap<>();
        int dataSize= Integer.parseInt(testCase[0]);
        int findSize= Integer.parseInt(testCase[1]);
        for(int i=0; i<dataSize; i++){
            String[] readData=br.readLine().split(" ");
            database.put(readData[0], readData[1]);
        }
        for(int i=0; i<findSize; i++){
            System.out.println(database.get(br.readLine()));
        }
    }
}