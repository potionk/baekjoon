package bj16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int[][] graph;
    static boolean[][] isBitten, bfsIsVisited;
    static int size, fishes, curSharkSize, exp;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        graph = new int[size][size];
        isBitten = new boolean[size][size];
        xArrow = new int[]{0, 1, -1, 0};
        yArrow = new int[]{-1, 0, 0, 1};
        fishes = 0;
        curSharkSize = 2;
        exp = 0;
        int result = 0;
        XY shark = null;

        for (int i = 0; i < size; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < size; j++) {
                graph[i][j] = Integer.parseInt(input[j] + "");
                if (graph[i][j] == 9) {
                    shark = new XY(j, i, 0);
                    graph[i][j] = 0;
                } else if (graph[i][j] > 0) {
                    fishes++;
                }
            }
        }
        while (fishes != 0) {
            bfsIsVisited = new boolean[size][size];
            XY s = bfs(shark.getY(), shark.getX());
            if (s == null) {
                break;
            }
            shark = s;
            result += shark.getTime();
        }
        System.out.println(result);
    }

    public static XY bfs(int y, int x) {
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y, 0));
        bfsIsVisited[y][x] = true;
        boolean isFirst = false;
        int firstTime = -1;
        int minX = -1;
        int minY = -1;
        while (queue.size() != 0) {
            XY next = queue.poll();
            x = next.getX();
            y = next.getY();
            int time = next.getTime();

            for (int i = 0; i < 4; i++) {
                int nextY = y + yArrow[i];
                int nextX = x + xArrow[i];
                if (!(nextY >= size) && !(nextX >= size) && !(nextY < 0) && !(nextX < 0) && graph[nextY][nextX] <= curSharkSize && !bfsIsVisited[nextY][nextX]) {
                    bfsIsVisited[nextY][nextX] = true;
                    if (graph[nextY][nextX] == 0 || graph[nextY][nextX] == curSharkSize) {
                        queue.add(new XY(nextX, nextY, time + 1));
                    } else if (graph[nextY][nextX] < curSharkSize && !isBitten[nextY][nextX]) {
                        if (!isFirst) {
                            isFirst = true;
                            minX = nextX;
                            minY = nextY;
                            firstTime = time + 1;
                        } else if (firstTime == time + 1) {
                            if (minY == nextY) {
                                if (minX > nextX) {
                                    minX = nextX;
                                    minY = nextY;
                                }
                            } else if (minY > nextY) {
                                minX = nextX;
                                minY = nextY;
                            }
                        }
                    }
                }
            }
        }
        if (!isFirst) {
            return null;
        } else {
            fishes--;
            exp++;
            if (exp == curSharkSize) {
                curSharkSize++;
                exp = 0;
            }
            isBitten[minY][minX] = true;
            graph[minY][minX] = 0;
            return new XY(minX, minY, firstTime);
        }
    }
}

class XY {
    int x;
    int y;
    int time;

    public XY(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getTime() {
        return time;
    }
}