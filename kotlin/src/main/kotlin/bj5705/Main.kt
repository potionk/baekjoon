package bj5705

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dp = IntArray(41)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    dp[4] = 5
    for (i in 5..40) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    while (true) {
        val n = br.readLine().trim().toInt()
        if (n == 0) {
            break
        }
        println(dp[n])
    }
}
