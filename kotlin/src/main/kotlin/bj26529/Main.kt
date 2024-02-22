package bj26529

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val dp = Array(46) { 0 }
    dp[0] = 1
    dp[1] = 1
    for (i in 2 .. 45) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }
    val n = br.readLine().toInt()
    repeat(n) {
        println(dp[br.readLine().toInt()])
    }
}
