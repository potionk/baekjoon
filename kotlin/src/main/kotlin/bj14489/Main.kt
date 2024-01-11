package bj14489

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val c = br.readLine().toInt()
    println(if (a + b >= c * 2) a + b - c * 2 else a + b)
}
