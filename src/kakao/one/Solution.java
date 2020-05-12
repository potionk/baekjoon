package kakao.one;

import java.util.LinkedList;

class Solution {
    static boolean[][] bfsIsVisited;
    static int[][] phone;
    static int[][] count;

//    public static void main(String[] args) {
//        Solution solution=new Solution();
////        String res=solution.solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");
////        String res=solution.solution(new int[]{7,0,8,2,8,3,1,5,7,6,2}, "left");
//        String res=solution.solution(new int[]{1,2,3,4,5,6,7,8,9,0}, "right");
//        System.out.println(res);
//    }

    public String solution(int[] numbers, String hand) {
        phone = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {-1, 0, -1}};
        bfsIsVisited = new boolean[4][3];
        StringBuilder sb = new StringBuilder();
        XY left = new XY(0, 3);     // *
        XY right = new XY(2, 3);    // #
        XY[] testCase = new XY[numbers.length];

        XY[] toXY = {new XY(1, 3), new XY(0, 0), new XY(1, 0), new XY(2, 0), new XY(0, 1), new XY(1, 1), new XY(2, 1), new XY(0, 2), new XY(1, 2), new XY(2, 2)};
        for (int i = 0; i < numbers.length; i++) {
            testCase[i] = toXY[numbers[i]];
        }

        for (int i = 0; i < numbers.length; i++) {
            switch (numbers[i]){
                case 1: case 4: case 7:
                    left=toXY[numbers[i]];
                    sb.append("L");
                    break;
                case 3: case 6: case 9:
                    right=toXY[numbers[i]];
                    sb.append("R");
                    break;
                default:
                    count = new int[4][3];
                    bfsIsVisited = new boolean[4][3];
                    bfs(left.getY(), left.getX(), true);
                    int leftCount = count[testCase[i].getY()][testCase[i].getX()];
                    count = new int[4][3];
                    bfsIsVisited = new boolean[4][3];
                    bfs(right.getY(), right.getX(), false);
                    int rightCount = count[testCase[i].getY()][testCase[i].getX()];
                    if (leftCount < rightCount) {
                        left = testCase[i];
                        sb.append("L");
                    } else if (leftCount > rightCount) {
                        right = testCase[i];
                        sb.append("R");
                    } else { // 같을때
                        if (hand.equals("right")) {
                            right = testCase[i];
                            sb.append("R");
                        } else {
                            left = testCase[i];
                            sb.append("L");
                        }
                    }
            }
        }

        String answer = sb.toString();
        return answer;
    }

    public static void bfs(int y, int x, boolean isLeft) {
        LinkedList<XY> queue = new LinkedList<>();
        queue.add(new XY(x, y));
        bfsIsVisited[y][x] = true;
        count[y][x] = 1;
        int[] xArrow;
        int[] yArrow;
        if (isLeft) {
            xArrow = new int[]{1, 0, 0};
            yArrow = new int[]{0, 1, -1};
        } else {
            xArrow = new int[]{-1, 0, 0};
            yArrow = new int[]{0, 1, -1};
        }
        while (queue.size() != 0) {
            XY next = queue.poll();
            x = next.getX();
            y = next.getY();
            for (int i = 0; i < 3; i++) {
                if (!(x + xArrow[i] >= 3) && !(x + xArrow[i] < 0) && !(y + yArrow[i] >= 4) && !(y + yArrow[i] < 0) && !bfsIsVisited[y + yArrow[i]][x + xArrow[i]]) {
                    queue.add(new XY(x + xArrow[i], y + yArrow[i]));
                    bfsIsVisited[y + yArrow[i]][x + xArrow[i]] = true;
                    count[y + yArrow[i]][x + xArrow[i]] = count[y][x] + 1;
                }
            }
        }
    }

}

class XY {
    int x;
    int y;

    public XY(int x, int y) {
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