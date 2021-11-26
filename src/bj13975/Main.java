package bj13975;

import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String[] arrStr = br.readLine().split(" ");
            PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
            for (String s : arrStr) {
                priorityQueue.add(Long.parseLong(s));
            }
            long result = 0;
            while (priorityQueue.size() > 1) {
                long sum = priorityQueue.poll() + priorityQueue.poll();
                result += sum;
                priorityQueue.add(sum);
            }
            bw.write(result + "\n");
        }
        br.close();
        bw.close();
    }
}
