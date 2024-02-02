package bj25625

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    println(if (x > y) x + y else y - x)
}
