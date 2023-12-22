package bj13229

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()
    val cumulativeSum = IntArray(n + 1)
    for (i in 1..n) {
        cumulativeSum[i] = cumulativeSum[i - 1] + list[i - 1]
    }
    for (i in 0 until m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        println(cumulativeSum[b + 1] - cumulativeSum[a])
    }
}
