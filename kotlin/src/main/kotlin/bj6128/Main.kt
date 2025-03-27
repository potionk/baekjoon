package bj6128

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val dp = Array(5) { LongArray(n + 1) }
    dp[0][0] = 1

    for (i in 1..4) {
        for (x in 0..n) {
            var sumWay = 0L
            for (k in 0..100) {
                val sq = k * k
                if (sq > x) break
                sumWay += dp[i - 1][x - sq]
            }
            dp[i][x] = sumWay
        }
    }

    println(dp[4][n])
}
