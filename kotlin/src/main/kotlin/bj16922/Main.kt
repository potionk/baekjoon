package bj16922

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val check = BooleanArray(n * 50 + 1)
    val visited = Array(n + 1) { BooleanArray(50 * n + 1) }
    val list = listOf(1, 5, 10, 50)
    fun dfs(index: Int = 0, sum: Int = 0) {
        if (index == n) {
            check[sum] = true
            return
        }
        if (visited[index][sum]) {
            return
        }
        visited[index][sum] = true
        for (i in 0 until 4) {
            dfs(index + 1, sum + list[i])
        }
    }
    dfs()
    println(check.count { it })
}
