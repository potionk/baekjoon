package bj9322;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        for (int i = 0; i < tcNum; i++) {
            int size = Integer.parseInt(br.readLine());
            Map<String, Integer> public1keyIdx = new HashMap<>();
            Map<String, Integer> public2keyIdx = new HashMap<>();
            Map<Integer, Integer> dict = new HashMap<>();
            String[] public1key = br.readLine().split(" ");
            String[] public2key = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                public1keyIdx.put(public1key[j], j);
                public2keyIdx.put(public2key[j], j);
            }
            for (int j = 0; j < size; j++) {
                dict.put(public1keyIdx.get(public1key[j]), public2keyIdx.get(public1key[j]));
            }
            String[] ciphertext = br.readLine().split(" ");
            String[] plaintext = new String[ciphertext.length];
            for (int j = 0; j < size; j++) {
                plaintext[j] = ciphertext[dict.get(j)];
            }
            for (int j = 0; j < size; j++) {
                bw.write(plaintext[j] + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
}
