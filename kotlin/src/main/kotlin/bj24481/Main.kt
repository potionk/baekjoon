package bj24481

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(System.out.bufferedWriter())
    val (n, m, r) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(n + 1) { false }
    val depth = IntArray(n + 1) { -1 }
    val adj = Array(n + 1) { mutableListOf<Int>() }
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
    }
    adj.forEach { it.sort() }
    dfs(visited, adj, r, depth)
    for (i in 1..n) {
        bw.write("${depth[i]}\n")
    }
    bw.close()
}

fun dfs(visited: BooleanArray, adj: Array<MutableList<Int>>, v: Int, depthArray: IntArray, depth: Int = 0) {
    visited[v] = true
    depthArray[v] = depth
    for (i in adj[v]) {
        if (!visited[i]) {
            dfs(visited, adj, i, depthArray, depth + 1)
        }
    }
}
