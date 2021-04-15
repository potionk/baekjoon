package bj9328;

import java.io.*;
import java.util.*;

public class Main {
    static int count;
    static int[] xArrow, yArrow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcNum = Integer.parseInt(br.readLine());
        xArrow = new int[]{0, 1, 0, -1};
        yArrow = new int[]{1, 0, -1, 0};
        while (tcNum-- > 0) {
            count = 0;
            String[] testCase = br.readLine().split(" ");
            int xSize = Integer.parseInt(testCase[1]);
            int ySize = Integer.parseInt(testCase[0]);
            char[][] graph = new char[ySize][xSize];
            boolean[][] bfsIsVisited = new boolean[ySize][xSize];
            for (int i = 0; i < ySize; i++) {
                String input = br.readLine();
                for (int j = 0; j < input.length(); j++) {
                    graph[i][j] = input.charAt(j);
                }
            }
            String keys = br.readLine();
            int keyLen = keys.length();
            Map<Character, List<Point>> door = new HashMap<>();
            Set<Character> key = new HashSet<>();
            for (int i = 0; i < keyLen; i++) {
                key.add(keys.charAt(i));
            }
            for (int i = 0; i < xSize; i++) {
                if (graph[0][i] != '*') {
                    bfs(0, i, bfsIsVisited, ySize, xSize, graph, door, key);
                }
                if (graph[ySize - 1][i] != '*') {
                    bfs(ySize - 1, i, bfsIsVisited, ySize, xSize, graph, door, key);
                }
            }
            for (int i = 0; i < ySize; i++) {
                if (graph[i][0] != '*') {
                    bfs(i, 0, bfsIsVisited, ySize, xSize, graph, door, key);
                }
                if (graph[i][xSize - 1] != '*') {
                    bfs(i, xSize - 1, bfsIsVisited, ySize, xSize, graph, door, key);
                }
            }
            bw.write(count + "\n");
        }
        bw.close();
        br.close();
    }

    public static void bfs(int y, int x, boolean[][] bfsIsVisited, int ySize, int xSize, char[][] graph, Map<Character, List<Point>> door, Set<Character> key) {
        LinkedList<Point> queue = new LinkedList<>();
        char thisPoint = graph[y][x];
        if (!bfsIsVisited[y][x]) {
            if (thisPoint == '.') {
                queue.add(new Point(x, y));
            } else if (isUpperCase(thisPoint)) {
                if (key.contains(upperToLower(thisPoint))) {
                    queue.add(new Point(x, y));
                } else {
                    List<Point> list;
                    if (door.get(thisPoint) == null) {
                        list = new LinkedList<>();
                    } else {
                        list = door.get(thisPoint);
                    }
                    list.add(new Point(x, y));
                    door.put(thisPoint, list);
                }
            } else if (thisPoint == '$') {
                count++;
                queue.add(new Point(x, y));
            } else { // key find
                key.add(thisPoint);
                char targetDoor = lowerToUpper(thisPoint);
                if (door.get(targetDoor) != null) {
                    queue.addAll(door.get(targetDoor));
                    door.remove(targetDoor);
                }
                queue.add(new Point(x, y));
            }
        }
        bfsIsVisited[y][x] = true;
        while (queue.size() != 0) {
            Point p = queue.poll();
            x = p.getX();
            y = p.getY();
            for (int i = 0; i < 4; i++) {
                int nextY = y + yArrow[i];
                int nextX = x + xArrow[i];
                if (!(nextY >= ySize) && !(nextX >= xSize) && !(nextY < 0) && !(nextX < 0)) {
                    char next = graph[nextY][nextX];
                    if (next != '*') {
                        if (!bfsIsVisited[nextY][nextX]) {
                            bfsIsVisited[nextY][nextX] = true;
                            if (next == '.') {
                                queue.add(new Point(nextX, nextY));
                            } else if (isUpperCase(next)) {
                                if (key.contains(upperToLower(next))) {
                                    queue.add(new Point(nextX, nextY));
                                } else {
                                    List<Point> list;
                                    if (door.get(next) == null) {
                                        list = new LinkedList<>();
                                    } else {
                                        list = door.get(next);
                                    }
                                    list.add(new Point(nextX, nextY));
                                    door.put(next, list);
                                }
                            } else if (next == '$') {
                                count++;
                                queue.add(new Point(nextX, nextY));
                            } else { // key find
                                key.add(next);
                                char targetDoor = lowerToUpper(next);
                                if (door.get(targetDoor) != null) {
                                    queue.addAll(door.get(targetDoor));
                                    door.remove(targetDoor);
                                }
                                queue.add(new Point(nextX, nextY));
                            }
                        }
                    }
                }
            }
        }
    }

    public static char upperToLower(char c) {
        return (char) (c + 32);
    }

    public static char lowerToUpper(char c) {
        return (char) (c - 32);
    }

    public static boolean isUpperCase(char c) {
        return 65 <= c && c <= 90;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}