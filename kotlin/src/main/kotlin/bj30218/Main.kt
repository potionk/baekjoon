package bj30218

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val list = mutableListOf<Long>()
    for (i in 0 until n) {
        list.add(br.readLine().toLong())
    }
    val cumulativeSum = mutableListOf<Long>()
    cumulativeSum.add(list[0])
    for (i in 1 until n) {
        cumulativeSum.add(cumulativeSum[i - 1] + list[i])
    }
    var sum = 0L
    for (i in 0 until k) {
        sum += list[i] * (i + 1)
    }
    val result = mutableListOf<Pair<Int, Long>>()
    result.add(Pair(1, sum))
    for (i in k until n) {
        sum -= cumulativeSum[i - 1] + if (i - k - 1 >= 0) -cumulativeSum[i - k - 1] else 0
        sum += list[i] * k
        result.add(Pair(i - k + 2, sum))
    }
    result.sortWith(compareBy({ it.second }, { it.first }))
    for (i in 0 until result.size) {
        println("${result[i].first} ${result[i].second}")
    }
}
