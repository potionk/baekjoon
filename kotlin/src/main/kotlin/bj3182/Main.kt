package bj3182

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val graph = mutableMapOf<Int, Int>()
    for (i in 1..n) {
        val a = br.readLine().toInt()
        graph[i] = a
    }
    var maxCount = -1
    var resultIdx = 0
    for (i in 1..n) {
        val count = dfs(i, graph)
        if (count > maxCount) {
            maxCount = count
            resultIdx = i
        }
    }
    println(resultIdx)
}

fun dfs(start: Int, graph: Map<Int, Int>, visited: MutableSet<Int> = mutableSetOf()): Int {
    if (visited.contains(start)) {
        return 0
    }
    visited.add(start)
    return dfs(graph[start]!!, graph, visited) + 1
}
