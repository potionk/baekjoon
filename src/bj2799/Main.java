package bj2799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        int ySize = Integer.parseInt(size[0]);
        int xSize = Integer.parseInt(size[1]);
        char[][] map = new char[ySize * 5 + 1][xSize * 5 + 1];
        Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < ySize * 5 + 1; i++) {
            String input = br.readLine();
            for (int j = 0; j < xSize * 5 + 1; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        for (int i = 1; i < ySize * 5 + 1; i += 5) {
            for (int j = 1; j < xSize * 5 + 1; j += 5) {
                int starCount = 0;
                for (int k = 0; k < 4; k++) {
                    if (map[i + k][j] == '*')
                        starCount++;
                }
                if (result.get(starCount) == null) {
                    result.put(starCount, 1);
                } else {
                    result.put(starCount, result.get(starCount) + 1);
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            if(result.get(i)!=null)
                System.out.print(result.get(i) + " ");
            else
                System.out.print(0+" ");
        }
    }
}
