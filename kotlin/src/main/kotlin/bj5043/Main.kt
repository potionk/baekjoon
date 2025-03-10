package bj5043

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, b) = br.readLine().split(" ").map { it.toLong() }
    val max = 1L shl ((b + 1).toInt())
    println(if (n < max) "yes" else "no")
}
