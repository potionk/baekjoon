package bj17216

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val dp = IntArray(n)
    val list = br.readLine().split(" ").map { it.toInt() }
    dp[0] = list[0]
    var max = dp[0]
    for (i in 1 until n) {
        dp[i] = list[i]
        for (j in 0 until i) {
            if (list[i] < list[j]) {
                dp[i] = maxOf(dp[i], dp[j] + list[i])
            }
        }
        max = maxOf(max, dp[i])
    }
    println(max)
}
