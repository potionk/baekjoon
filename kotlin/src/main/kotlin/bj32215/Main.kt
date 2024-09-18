package bj32215

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    if (k == n) println(m * k)
    else println(m * k + m)
}
