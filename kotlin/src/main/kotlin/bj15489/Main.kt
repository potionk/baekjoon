package bj15489

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c, w) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(31) { IntArray(31) }
    for (i in 1..30) {
        for (j in 1..30) {
            dp[i][j] = if (j == 1 || j == i) 1 else dp[i - 1][j - 1] + dp[i - 1][j]
        }
    }
    var sum = 0
    for (i in 0 until w) {
        for (j in 0..i) {
            sum += dp[r + i][c + j]
        }
    }
    println(sum)
}
