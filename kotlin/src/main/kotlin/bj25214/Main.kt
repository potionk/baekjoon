package bj25214

import java.io.*
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val dp = IntArray(n)
    var min = list[0]
    bw.write("0 ")
    for (i in 1 until n) {
        min = min(min, list[i])
        dp[i] = max(dp[i - 1], list[i] - min)
        bw.write("${dp[i]} ")
    }
    bw.close()
}
