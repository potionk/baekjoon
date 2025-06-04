package bj26332

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (c, p) = br.readLine().split(" ").map { it.toInt() }
        println("$c $p")
        println("${c * p - (2 * (c - 1))}")
    }
}
