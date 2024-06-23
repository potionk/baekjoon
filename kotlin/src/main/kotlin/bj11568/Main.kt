package bj11568

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n)
    for (i in cards.indices) {
        dp[i] = 1
        for (j in 0 until i) {
            if (cards[j] < cards[i] && dp[i] < dp[j] + 1) {
                dp[i] = dp[j] + 1
            }
        }
    }
    println(dp.maxOrNull())
}
