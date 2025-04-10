package bj32981

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val dp = LongArray(10000001)
    val n = br.readLine().toInt()
    dp[1] = 4
    for (i in 2..10000000) {
        dp[i] = (dp[i - 1] * 5) % 1000000007
    }
    dp[1] = 5
    repeat(n) {
        bw.write("${dp[br.readLine().toInt()]}\n")
    }
    bw.close()
}
