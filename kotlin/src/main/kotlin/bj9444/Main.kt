package bj9444

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val scoreArray = Array(n) { 0 }
    val candidates = mutableListOf<String>()
    var invalidCount = 0
    repeat(n) {
        candidates.add(br.readLine())
    }
    repeat(m) {
        val vote = br.readLine()
        var idx = -1
        var xCount = 0
        for (i in 0 until n) {
            if (vote[i] == 'X') {
                idx = i
                xCount++
            }
        }
        if (xCount == 1) {
            scoreArray[idx]++
        } else {
            invalidCount++
        }
    }
    val candidateScorePair = candidates.zip(scoreArray)
    candidateScorePair.sortedByDescending { it.second }.forEach {
        println("${it.first} ${String.format("%.2f", it.second.toDouble() / m * 100)}%")
    }
    println("Invalid ${String.format("%.2f", invalidCount.toDouble() / m * 100)}%")
}
