package bj17478;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] answer = {"\"재귀함수가 뭔가요?\"\n", "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n", "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n", "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n", "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n", "라고 답변하였지.\n"};
        int N = Integer.parseInt(br.readLine());
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        print(0, N, answer, bw);
        br.close();
        bw.close();
    }

    public static void print(int depth, int N, String[] answer, BufferedWriter bw) throws IOException {
        if (depth == N) {
            int[] idx = {0, 4, 5};
            for (int i = 0; i < 3; i++) {
                depthPrint(depth, bw);
                bw.write(answer[idx[i]]);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                depthPrint(depth, bw);
                bw.write(answer[i]);
            }
            print(depth + 1, N, answer, bw);
            depthPrint(depth, bw);
            bw.write(answer[5]);
        }
    }

    public static void depthPrint(int depth, BufferedWriter bw) throws IOException {
        for (int i = 0; i < depth; i++) {
            bw.write("____");
        }
    }
}