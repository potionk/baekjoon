package bj33868

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var maxT = 0
    var minB = Int.MAX_VALUE
    repeat(n) {
        val (t, b) = br.readLine().split(" ").map { it.toInt() }
        maxT = maxOf(maxT, t)
        minB = minOf(minB, b)
    }
    println((maxT * minB) % 7 + 1)
}
