package bj2355

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toLong() }
    val min = minOf(a, b)
    val max = maxOf(a, b)
    println((max * (max + 1) / 2) - (min * (min - 1) / 2))
}
