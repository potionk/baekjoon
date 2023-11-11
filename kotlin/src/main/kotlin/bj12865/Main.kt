package bj12865

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (count, weight) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(count) { IntArray(weight + 1) }
    for (i in 0 until count) {
        val (w, v) = br.readLine().split(" ").map { it.toInt() }
        for (j in 1..weight) {
            if (i == 0 && j >= w) {
                dp[i][j] = v
            } else if (i > 0) {
                if (j >= w) {
                    dp[i][j] = max(v + dp[i - 1][j - w], dp[i - 1][j])
                } else {
                    dp[i][j] = dp[i - 1][j]
                }
            }
        }
    }
    println(dp[count - 1][weight])
}
