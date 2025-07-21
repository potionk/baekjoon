package bj33783

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, s) = br.readLine().trim().split(" ").map { it.toInt() }
    val graph = Array(n) { mutableListOf<Int>() }
    repeat(m) {
        val splitInput = br.readLine().trim().split(" ")
        if (splitInput.size == 2) {
            val (a, b) = splitInput.map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }
    }
    fun bfs(start: Int): Boolean {
        val visited = BooleanArray(n)
        val queue = mutableListOf<Int>()
        visited[start] = true
        queue.add(start)
        var count = 1
        while (queue.isNotEmpty()) {
            val curr = queue.removeAt(0)
            for (next in graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true
                    queue.add(next)
                    count++
                }
            }
        }
        return count == n
    }
    println(if (bfs(s)) "yes" else "no")
}
