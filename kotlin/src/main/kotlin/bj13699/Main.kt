package bj13699

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = LongArray(n + 1)
    dp[0] = 1
    for (i in 1..n) {
        for (j in 0 until i) {
            dp[i] += dp[j] * dp[i - j - 1]
        }
    }
    print(dp[n])
    br.close()
}
