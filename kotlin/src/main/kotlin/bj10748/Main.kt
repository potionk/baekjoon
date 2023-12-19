package bj10748

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (r, c, k) = br.readLine().split(" ").map { it.toInt() }
    val grid = Array(r) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = Array(r) { LongArray(c) }
    dp[0][0] = 1

    for (a in 0 until r) {
        for (b in 0 until c) {
            for (i in 0 until a) {
                for (j in 0 until b) {
                    if (grid[i][j] != grid[a][b]) {
                        dp[a][b] += dp[i][j]
                        dp[a][b] = dp[a][b] % 1000000007
                    }
                }
            }
        }
    }

    println(dp[r - 1][c - 1])
}
