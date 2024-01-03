package bj24484

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader

var orderCount = 1

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(System.out.bufferedWriter())
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(n + 1) { false }
    val depth = IntArray(n + 1) { -1 }
    val order = IntArray(n + 1)
    val adj = Array(n + 1) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
    }
    adj.forEach { it.sortDescending() }
    dfs(visited, adj, r, depth, 0, order)
    var result = 0L
    for (i in 1..n) {
        result += depth[i] * order[i].toLong()
    }
    bw.write("$result")
    bw.close()
}

fun dfs(
    visited: BooleanArray,
    adj: Array<MutableList<Int>>,
    v: Int,
    depthArray: IntArray,
    depth: Int = 0,
    order: IntArray
) {
    visited[v] = true
    depthArray[v] = depth
    order[v] = orderCount++
    for (i in adj[v]) {
        if (!visited[i]) {
            dfs(visited, adj, i, depthArray, depth + 1, order)
        }
    }
}
