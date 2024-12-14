package bj17203

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, q) = br.readLine().split(" ").map { it.toInt() }
    val cumulativeSum = IntArray(n + 1)
    val list = br.readLine().split(" ").map { it.toInt() }
    for (i in 1 until n) {
        cumulativeSum[i] = cumulativeSum[i - 1] + abs(list[i - 1] - list[i])
    }
    repeat(q) {
        val (l, r) = br.readLine().split(" ").map { it.toInt() - 1 }
        println(cumulativeSum[r] - cumulativeSum[l])
    }
}
