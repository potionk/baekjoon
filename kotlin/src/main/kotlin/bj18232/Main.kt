package bj18232

import java.io.*

val dn = intArrayOf(1, -1)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val (s, e) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[x].add(y)
        graph[y].add(x)
    }
    println(bfs(graph, s, e))
}

fun bfs(graph: Array<MutableList<Int>>, a: Int, b: Int): Int {
    val q = mutableListOf<Int>()
    val n = graph.size
    val visited = BooleanArray(n)
    q.add(a)
    visited[a] = true
    var count = 0
    while (q.isNotEmpty()) {
        val size = q.size
        for (i in 0 until size) {
            val cur = q.removeFirst()
            if (cur == b) return count
            for (next in graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true
                    q.add(next)
                }
            }
            for (dn in dn) {
                val next = cur + dn
                if (next in 1 until n && !visited[next]) {
                    visited[next] = true
                    q.add(next)
                }
            }
        }
        count++
    }
    return -1
}

