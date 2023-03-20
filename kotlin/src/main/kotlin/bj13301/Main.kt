package bj13301

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dp = LongArray(81)
    dp[1] = 1
    dp[2] = 1
    for (i in 3..80) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    val n = br.readLine().toInt()
    println(dp[n] * 4 + dp[n - 1] * 2)
    br.close()
}
