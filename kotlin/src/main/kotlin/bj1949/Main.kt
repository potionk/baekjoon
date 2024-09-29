package bj1949

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<Int, List<Int>>()
    val dp = Array(n + 1) { IntArray(2) }
    val people = br.readLine().split(" ").map { it.toInt() }
    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        map[a] = map.getOrDefault(a, listOf()) + b
        map[b] = map.getOrDefault(b, listOf()) + a
    }
    fun dfs(v: Int, parent: Int) {
        dp[v][0] = 0
        dp[v][1] = people[v - 1]
        for (i in map[v]!!) {
            if (i == parent) continue
            dfs(i, v)
            dp[v][0] += maxOf(dp[i][0], dp[i][1])
            dp[v][1] += dp[i][0]
        }
    }
    dfs(1, 0)
    println(maxOf(dp[1][0], dp[1][1]))
}
