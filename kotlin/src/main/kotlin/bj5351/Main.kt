package bj5351

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val coins = br.readLine().split(" ").map { it.toInt() }
        val dp = IntArray(coins.size)
        dp[0] = coins[0]
        dp[1] = maxOf(coins[0], coins[1])
        for (i in 2 until coins.size) {
            dp[i] = maxOf(dp[i - 1], dp[i - 2] + coins[i])
        }
        println(dp.last())
    }
}
