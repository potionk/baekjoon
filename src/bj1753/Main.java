import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static ArrayList<Pair<Integer, Integer>>[] graph;
    static PriorityQueue<Vertex> priorityQueue;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        priorityQueue = new PriorityQueue<>();
        String[] vertexEdge = br.readLine().split(" ");
        int vertex = Integer.parseInt(vertexEdge[0]);
        int edge = Integer.parseInt(vertexEdge[1]);
        int startVertex = Integer.parseInt(br.readLine());
        dist = new int[vertex + 1];
        graph = new ArrayList[vertex + 1];
        for (int i = 0; i < vertex + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edge; i++) {
            String[] readEdge = br.readLine().split(" ");
            int start = Integer.parseInt(readEdge[0]);
            int finish = Integer.parseInt(readEdge[1]);
            int weight = Integer.parseInt(readEdge[2]);
            graph[start].add(new Pair<>(finish, weight));
        }
        for (int i = 1; i <= vertex; i++) {
            dist[i] = Integer.MAX_VALUE;
            Vertex v;
            if (i == startVertex)
                v = new Vertex(i, 0);
            else
                v = new Vertex(i, Integer.MAX_VALUE);
            priorityQueue.add(v);
        }
        dist[startVertex]=0;
        dijkstra(startVertex);
        for(int i=1; i<=vertex; i++){
            if(dist[i]== Integer.MAX_VALUE)
                bw.write("INF\n");
            else
                bw.write(dist[i]+"\n");
        }
        bw.flush();
    }

    public static void dijkstra(int start) {
        while (true) {
            Vertex p = priorityQueue.poll();
//            int postIndex = p.getIndex();
            int post=dist[p.getIndex()];
            if (p.getDist() == Integer.MAX_VALUE)
                break;
            if (post >= p.getDist()) {
                ArrayList<Pair<Integer, Integer>> list = graph[p.getIndex()];
                for (int i = 0; i < list.size(); i++) {
                    Pair<Integer, Integer> next = list.get(i);
                    int nextIndex=next.getLeft();
                    int weight=next.getRight();
                    if(dist[nextIndex]>post+weight){
                        priorityQueue.add(new Vertex(nextIndex, post+weight));
                        dist[nextIndex]=post+weight;
                    }
                }
            }

        }
    }

}

class Vertex implements Comparable<Vertex> {
    int index;
    int dist;

    public Vertex(int index, int dist) {
        this.index = index;
        this.dist = dist;
    }

    public int getIndex() {
        return index;
    }


    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    @Override
    public int compareTo(Vertex target) {
        if (this.dist < target.dist) {
            return -1;
        } else if (this.dist == target.dist) {
            return 0;
        } else {
            return 1;
        }
    }
}

class Pair<E, F> {
    public E left;
    public F right;

    public Pair(E left, F right) {
        this.left = left;
        this.right = right;
    }

    public E getLeft() {
        return left;
    }

    public F getRight() {
        return right;
    }
}