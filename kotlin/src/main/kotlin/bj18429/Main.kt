package bj18429

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    fun dfs(sum: Int, visited: BooleanArray, cur: Int): Int {
        if (sum < 500) return 0
        if (cur == n) return 1
        var count = 0
        for (i in 0 until n) {
            if (!visited[i]) {
                visited[i] = true
                count += dfs(sum + list[i] - k, visited, cur + 1)
                visited[i] = false
            }
        }
        return count
    }
    println(dfs(500, BooleanArray(n), 0))
}
