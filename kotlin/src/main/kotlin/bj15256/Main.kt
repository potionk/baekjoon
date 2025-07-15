package bj15256

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().trim().toInt()
    repeat(k) { idx ->
        val n = br.readLine().trim().toInt()
        val steps = br.readLine().trim().split(" ").map { it.toDouble() }
        var result = 0.0
        val startIndex = steps.indexOfFirst { it in 30.0..30.2 }
        if (startIndex != -1 && startIndex + 3 < n) {
            result = steps.subList(startIndex + 3, n).minOrNull()!! - 30.0
        }
        println("Data Set ${idx + 1}:")
        println(String.format("%.2f", result))
        println()
    }
}
