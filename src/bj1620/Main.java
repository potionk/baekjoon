package bj1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] testCase= br.readLine().split(" ");
        int pokeSize= Integer.parseInt(testCase[0]);
        int questionSize= Integer.parseInt(testCase[1]);
        Map<Integer, String> pokemonBookByIndex = new HashMap<>();
        Map<String, Integer> pokemonBookByName = new HashMap<>();
        for(int i=0; i<pokeSize; i++){
            String input=br.readLine();
            pokemonBookByIndex.put(i+1, input);
            pokemonBookByName.put(input, i+1);
        }
        for(int i=0; i<questionSize; i++){
            String cmd=br.readLine();
            if(isInteger(cmd)){
                System.out.println(pokemonBookByIndex.get(Integer.parseInt(cmd)));
            } else {
                System.out.println(pokemonBookByName.get(cmd));
            }
        }
    }
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}