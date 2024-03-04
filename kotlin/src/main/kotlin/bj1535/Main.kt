package bj1535

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val l = br.readLine().split(" ").map { it.toInt() }
    val pleasure = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { IntArray(101) }
    for (i in 1..n) {
        for (j in 1..100) {
            dp[i][j] = dp[i - 1][j]
            if (j >= l[i - 1]) {
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j - l[i - 1]] + pleasure[i - 1])
            }
        }
    }
    println(dp[n][99])
}
