package bj27267

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c, d) = br.readLine().split(" ").map { it.toInt() }
    println(if (a * b > c * d) "M" else if (a * b < c * d) "P" else "E")
}
