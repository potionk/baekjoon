package bj2896

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toDouble() }
    val (i, j, k) = br.readLine().split(" ").map { it.toDouble() }
    val min = minOf(a / i, b / j, c / k)
    println("${a - i * min} ${b - j * min} ${c - k * min}")
}
