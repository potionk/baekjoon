package bj14494

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { LongArray(m + 1) }
    dp[0][0] = 1
    for (i in 1..n) {
        for (j in 1..m) {
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1]) % 1000000007
        }
    }
    println(dp[n][m])
}
