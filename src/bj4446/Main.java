package bj4446;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tc;
        while ((tc = br.readLine()) != null) {
            char[] input = tc.toCharArray();
            Map<Character, Integer> vowelIdxMap = new HashMap<>();
            Map<Character, Integer> consonantIdMap = new HashMap<>();
            char[] vowel = {'a', 'i', 'y', 'e', 'o', 'u'};
            char[] consonant = {'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'};
            for (int i = 0; i < vowel.length; i++) {
                vowelIdxMap.put(vowel[i], i);
            }
            for (int i = 0; i < consonant.length; i++) {
                consonantIdMap.put(consonant[i], i);
            }
            for (int i = 0; i < input.length; i++) {
                switch (input[i]) {
                    case 'a', 'i', 'y', 'e', 'o', 'u' -> input[i] = vowel[(vowelIdxMap.get(input[i]) + 3) % vowel.length];
                    case 'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f' -> input[i] = consonant[(consonantIdMap.get(input[i]) + 10) % consonant.length];
                    case 'A', 'I', 'Y', 'E', 'O', 'U' -> input[i] = (char) (vowel[(vowelIdxMap.get((char) (input[i] + 32)) + 3) % vowel.length] - 32);
                    case 'B', 'K', 'X', 'Z', 'N', 'H', 'D', 'C', 'W', 'G', 'P', 'V', 'J', 'Q', 'T', 'S', 'R', 'L', 'M', 'F' -> input[i] = (char) (consonant[(consonantIdMap.get((char) (input[i] + 32)) + 10) % consonant.length] - 32);
                }
            }
            bw.write(new String(input)+"\n");
        }
        br.close();
        bw.close();
    }
}
