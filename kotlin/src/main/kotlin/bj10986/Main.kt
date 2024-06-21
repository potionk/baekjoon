package bj10986

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val arr = br.readLine().split(" ").map { it.toInt() }
    val prefixSum = LongArray(n)
    prefixSum[0] = arr[0].toLong()
    for (i in 1 until n) {
        prefixSum[i] = prefixSum[i - 1] + arr[i]
    }

    val remainder = prefixSum.map { it % m }
    val remainderCount = mutableMapOf<Long, Long>()
    for (r in remainder) {
        remainderCount[r] = remainderCount.getOrDefault(r, 0) + 1
    }

    var answer = remainderCount.getOrDefault(0, 0)
    for (count in remainderCount.values) {
        answer += calCombination(count)
    }
    println(answer)
}

fun calCombination(n: Long): Long {
    return n * (n - 1) / 2
}
