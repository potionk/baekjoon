package bj31450

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, k) = br.readLine().split(" ").map { it.toInt() }
    println(if (m % k == 0) "Yes" else "No")
}
