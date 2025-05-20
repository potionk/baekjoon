package bj33964

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    println(repunit(x) + repunit(y))
}

fun repunit(n: Int): Int {
    return "1".repeat(n).toInt()
}