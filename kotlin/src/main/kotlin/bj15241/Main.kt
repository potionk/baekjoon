package bj15241

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val board = Array(n) { br.readLine().toCharArray() }
    val dp = Array(n) { LongArray(m) }
    if (board[0][0] == 'X') {
        println(0)
        return
    }
    dp[0][0] = 1
    for (i in 1 until n) {
        if (board[i][0] == 'X') break
        dp[i][0] = 1
    }
    for (i in 1 until m) {
        if (board[0][i] == 'X') break
        dp[0][i] = 1
    }
    for (i in 1 until n) {
        for (j in 1 until m) {
            if (board[i][j] == 'X') continue
            dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007
        }
    }
    println(dp[n - 1][m - 1])
}
