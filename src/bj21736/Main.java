package bj21736;

import java.io.*;

public class Main {
    static final int[] X_ARROW = {0, 1, 0, -1}, Y_ARROW = {1, 0, -1, 0};
    static int count, ySize, xSize, doyeonY, doyeonX;
    static char[][] campus;

    public static void main(String[] args) throws IOException {
        init();

        boolean[][] visited = new boolean[ySize][xSize];
        visited[doyeonY][doyeonX] = true;
        dfs(doyeonY, doyeonX, ySize, xSize, visited);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (count == 0) {
            bw.write("TT");
        } else {
            bw.write(count + "");
        }
        bw.close();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        ySize = Integer.parseInt(NM[0]);
        xSize = Integer.parseInt(NM[1]);
        campus = new char[ySize][xSize];
        doyeonY = -1;
        doyeonX = -1;
        for (int i = 0; i < ySize; i++) {
            String readLine = br.readLine();
            for (int j = 0; j < xSize; j++) {
                campus[i][j] = readLine.charAt(j);
                if (campus[i][j] == 'I') {
                    doyeonY = i;
                    doyeonX = j;
                }
            }
        }
        br.close();
    }

    public static void dfs(int y, int x, int ySize, int xSize, boolean[][] visited) {
        if (campus[y][x] == 'P') {
            count++;
        }
        for (int i = 0; i < 4; i++) {
            int nextY = y + Y_ARROW[i];
            int nextX = x + X_ARROW[i];
            if (isValidatedPoint(nextY, nextX, ySize, xSize) && campus[nextY][nextX] != 'X' && !visited[nextY][nextX]) {
                visited[nextY][nextX] = true;
                dfs(nextY, nextX, ySize, xSize, visited);
            }
        }
    }

    public static boolean isValidatedPoint(int nextY, int nextX, int ySize, int xSize) {
        return !(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0);
    }
}
