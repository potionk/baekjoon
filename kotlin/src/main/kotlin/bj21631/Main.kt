package bj21631

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toLong() }
    if (a >= b) println(b) else println(a + 1)
}
