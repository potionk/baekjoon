package bj28519

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    println(if (n == m) n + m else 2 * minOf(n, m) + 1)
}
