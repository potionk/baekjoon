package bj23741

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, start, availableMove) = br.readLine().split(" ").map { it.toInt() }
    val graph = mutableMapOf<Int, MutableSet<Int>>()
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        graph.getOrPut(a) { mutableSetOf() }.add(b)
        graph.getOrPut(b) { mutableSetOf() }.add(a)
    }
    bfs(graph, start, availableMove).forEach { print("$it ") }
}

fun bfs(graph: Map<Int, Set<Int>>, start: Int, availableMove: Int): List<Int> {
    val queue = mutableListOf(start)
    val result = mutableListOf<Int>()
    var depth = 0
    while (queue.isNotEmpty()) {
        if (depth >= availableMove) {
            return queue.toSet().sorted()
        } else {
            val size = queue.size
            val visited = mutableSetOf<Int>()
            repeat(size) {
                val current = queue.removeFirst()
                result.add(current)
                graph[current]?.forEach {
                    if (!visited.contains(it)) {
                        queue.add(it)
                        visited.add(it)
                    }
                }
            }
            depth++
        }
    }
    return listOf(-1)
}
