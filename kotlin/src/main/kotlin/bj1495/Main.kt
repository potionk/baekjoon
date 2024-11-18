package bj1495

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, s, m) = br.readLine().split(" ").map { it.toInt() }
    val volumes = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { BooleanArray(m + 1) { false } }
    dp[0][s] = true
    for (i in 1..n) {
        for (j in 0..m) {
            if (dp[i - 1][j]) {
                if (j - volumes[i - 1] >= 0) {
                    dp[i][j - volumes[i - 1]] = true
                }
                if (j + volumes[i - 1] <= m) {
                    dp[i][j + volumes[i - 1]] = true
                }
            }
        }
    }
    for (i in m downTo 0) {
        if (dp[n][i]) {
            println(i)
            return
        }
    }
    println(-1)
}
