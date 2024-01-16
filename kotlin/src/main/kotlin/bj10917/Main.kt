package bj10917

import java.io.*
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph[a].add(b)
    }
    println(bfs(graph, n))
}

fun bfs(graph: Array<MutableList<Int>>, target: Int): Int {
    val queue: Queue<Int> = LinkedList()
    queue.add(1)
    val visited = BooleanArray(graph.size) { false }
    visited[1] = true
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        for (i in 0 until size) {
            val current = queue.poll()
            if (current == target) {
                return count
            }
            for (next in graph[current]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.add(next)
                }
            }
        }
        count++
    }
    return -1
}
