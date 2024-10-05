package bj10164

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val middleY = if (k == 0) n - 1 else (k - 1) / m
    val middleX = if (k == 0) m - 1 else (k - 1) % m
    val dp = Array(n) { IntArray(m) }
    for (i in 0..middleY) {
        dp[i][0] = 1
    }
    for (j in 0..middleX) {
        dp[0][j] = 1
    }
    for (i in 1 until n) {
        for (j in 1 until m) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    val middle = dp[middleY][middleX]
    if (k == 0) {
        println(middle)
        return
    }
    for (i in middleY until n) {
        dp[i][middleX] = 1
    }
    for (j in middleX until m) {
        dp[middleY][j] = 1
    }
    for (i in middleY + 1 until n) {
        for (j in middleX + 1 until m) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
        }
    }
    println(middle * dp[n - 1][m - 1])
}
