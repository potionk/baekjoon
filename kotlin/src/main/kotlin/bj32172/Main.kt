package bj32172

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val visited = mutableSetOf<Int>()
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)
    dp[0] = 0
    visited.add(0)
    for (i in 1..n) {
        if (visited.contains(dp[i - 1] - i)) {
            dp[i] = dp[i - 1] + i
            visited.add(dp[i])
        } else {
            if (dp[i - 1] - i < 0) {
                dp[i] = dp[i - 1] + i
                visited.add(dp[i])
            } else {
                dp[i] = dp[i - 1] - i
                visited.add(dp[i])
            }
        }
    }
    println(dp[n])
}
