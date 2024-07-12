package bj15591

import java.io.*
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (n, q) = br.readLine().split(" ").map { it.toInt() }
    val graph = List(n + 1) { mutableListOf<Pair<Int, Int>>() }
    repeat(n - 1) {
        val (p1, p2, r) = br.readLine().split(" ").map { it.toInt() }
        graph[p1].add(Pair(p2, r))
        graph[p2].add(Pair(p1, r))
    }
    repeat(q) {
        val (k, v) = br.readLine().split(" ").map { it.toInt() }
        bw.write("${bfs(graph, v, k)}\n")
    }
    bw.close()
}

fun bfs(graph: List<List<Pair<Int, Int>>>, start: Int, k: Int): Int {
    val visited = BooleanArray(graph.size)
    val queue = LinkedList<Int>()
    queue.add(start)
    visited[start] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        graph[current].forEach {
            if (!visited[it.first] && it.second >= k) {
                visited[it.first] = true
                queue.add(it.first)
                count++
            }
        }
    }
    return count
}
