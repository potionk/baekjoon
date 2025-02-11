package bj27262

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k, a, b) = br.readLine().split(" ").map { it.toInt() }
    val lift = (k - 1) * b + (n - 1) * b
    val stairs = (n - 1) * a
    println("$lift $stairs")
}
