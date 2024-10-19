package bj30489

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toLong() }.sortedDescending()
    println(list.subList(0, minOf(n, m + k)).sum().toDouble() / list.sum() * 100)
}
