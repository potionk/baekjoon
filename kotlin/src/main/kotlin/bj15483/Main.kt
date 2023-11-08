package bj15483

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine()
    val b = br.readLine()
    val dp = Array(a.length + 1) { IntArray(b.length + 1) }
    for (i in a.indices) {
        dp[i + 1][0] = i + 1
    }
    for (i in b.indices) {
        dp[0][i + 1] = i + 1
    }
    for (i in 1..a.length) {
        for (j in 1..b.length) {
            if (a[i - 1] == b[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1]
            } else {
                dp[i][j] = minOf(minOf(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1
            }
        }
    }
    println(dp[a.length][b.length])
}
