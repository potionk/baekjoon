package bj17485

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    val dx = intArrayOf(-1, 0, 1)
    val dy = intArrayOf(1, 1, 1)
    var answer = Int.MAX_VALUE
    val dp = Array(n) { Array(m) { IntArray(3) { -1 } } }
    for (i in 0 until m) {
        for (j in 0 until 3) {
            dp[0][i][j] = arr[0][i]
        }
    }
    for (y in 0 until n) {
        for (x in 0 until m) {
            for (k in 0 until 3) {
                for (l in 0 until 3) {
                    val nx = x + dx[l]
                    val ny = y + dy[l]
                    if (k != l && dp[y][x][k] != -1 && nx in 0 until m && ny in 0 until n) {
                        if (dp[ny][nx][l] == -1) {
                            dp[ny][nx][l] = dp[y][x][k] + arr[ny][nx]
                        } else {
                            dp[ny][nx][l] = min(dp[ny][nx][l], dp[y][x][k] + arr[ny][nx])
                        }
                    }
                }
            }
        }
    }
    for (i in 0 until m) {
        for (j in 0 until 3) {
            if (dp[n - 1][i][j] != -1) {
                answer = min(answer, dp[n - 1][i][j])
            }
        }
    }
    println(answer)
}
