package bj33046

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val (c, d) = br.readLine().split(" ").map { it.toInt() }
    val gadong = (a + b - 1) % 4 + 1
    val jindong = ((gadong - 1) + c + d - 1) % 4 + 1
    println(jindong)
}
