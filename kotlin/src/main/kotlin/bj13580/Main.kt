package bj13580

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    if (a + b - c == 0 || a + c - b == 0 || b + c - a == 0 || a - b == 0 || a - c == 0 || b - c == 0) {
        println("S")
    } else {
        println("N")
    }
}
