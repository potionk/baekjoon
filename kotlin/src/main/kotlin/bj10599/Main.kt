package bj10599

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (a, b, c, d) = br.readLine().split(" ").map { it.toInt() }
        if (a == b && b == c && c == d && d == 0) {
            break
        }
        println("${c - b} ${d - a}")
    }
}
