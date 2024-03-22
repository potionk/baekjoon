package bj25511

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    repeat(n - 1) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[x].add(y)
    }
    val values = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    for (i in 0 until n) {
        map[i] = values[i]
    }
    println(dfs(graph, map, 0, 0, k))
}

fun dfs(graph: Array<MutableList<Int>>, map: MutableMap<Int, Int>, depth: Int, node: Int, k: Int): Int {
    if (map[node] == k) {
        return depth
    }
    var result = 0
    for (next in graph[node]) {
        result = dfs(graph, map, depth + 1, next, k)
        if (result != 0) {
            break
        }
    }
    return result
}
