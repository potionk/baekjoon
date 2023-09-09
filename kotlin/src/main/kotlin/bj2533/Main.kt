package bj2533

import java.io.*

lateinit var dp: Array<IntArray>
lateinit var visited: BooleanArray
lateinit var graph: Array<ArrayList<Int>>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    dp = Array(n + 1) { IntArray(2) }
    visited = BooleanArray(n + 1)
    graph = Array(n + 1) { ArrayList() }

    for (i in 0 until n - 1) {
        val (u, v) = br.readLine().split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
    }
    dfs(1)
    println(minOf(dp[1][0], dp[1][1]))
}

fun dfs(cur: Int) {
    visited[cur] = true
    dp[cur][1] = 1

    for (next in graph[cur]) {
        if (!visited[next]) {
            dfs(next)
            dp[cur][0] += dp[next][1]
            dp[cur][1] += minOf(dp[next][0], dp[next][1])
        }
    }
}
