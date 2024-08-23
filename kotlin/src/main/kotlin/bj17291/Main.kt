package bj17291

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = IntArray(21)
    dp[0] = 1
    dp[1] = 1
    for (i in 2..n) {
        dp[i] = dp[i - 1] * 2
        if (i % 2 == 0) {
            if (i >= 5) dp[i] -= dp[i - 5]
            if (i >= 4) dp[i] -= dp[i - 4]
        }
    }
    println(dp[n])
}
