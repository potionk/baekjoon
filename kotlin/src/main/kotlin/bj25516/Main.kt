package bj25516

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val visited = BooleanArray(n) { false }
    val adj = Array(n) { mutableListOf<Int>() }
    for (i in 0 until n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        adj[a].add(b)
        adj[b].add(a)
    }
    val apple = br.readLine().split(" ").map { it.toInt() }
    println(dfs(visited, adj, 0, apple, 0, k))
}

fun dfs(
    visited: BooleanArray,
    adj: Array<MutableList<Int>>,
    v: Int,
    apple: List<Int>,
    depth: Int = 1,
    k: Int
): Int {
    if (depth > k) return 0
    var count = apple[v]
    visited[v] = true
    for (i in adj[v]) {
        if (!visited[i]) {
            count += dfs(visited, adj, i, apple, depth + 1, k)
        }
    }
    return count
}
