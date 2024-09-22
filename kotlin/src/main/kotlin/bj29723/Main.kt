package bj29723

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        map[a] = b.toInt()
    }
    var minScore = 0
    var maxScore = 0
    for (i in 0 until k) {
        val t = br.readLine()
        val score = map[t]!!
        minScore += score
        maxScore += score
        map.remove(t)
    }
    val sortedScore = map.values.sorted()
    minScore += sortedScore.take(m - k).sum()
    maxScore += sortedScore.takeLast(m - k).sum()
    println("$minScore $maxScore")
}
