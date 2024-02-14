package bj19947

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, y) = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(y + 1)
    dp[0] = h
    for (i in 1..y) {
        dp[i] = (dp[i - 1] * 1.05).toInt()
        if (i >= 3) dp[i] = maxOf(dp[i], (dp[i - 3] * 1.2).toInt())
        if (i >= 5) dp[i] = maxOf(dp[i], (dp[i - 5] * 1.35).toInt())
    }
    println(dp[y])
}
