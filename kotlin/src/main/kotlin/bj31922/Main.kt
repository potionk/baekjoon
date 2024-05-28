package bj31922

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, p, c) = br.readLine().split(" ").map { it.toInt() }
    println(Math.max(a + c, p))
}
