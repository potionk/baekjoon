package bj15025

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (a == 0 && b == 0) {
            "Not a moose"
        } else if (a == b) {
            "Even ${a * 2}"
        } else {
            "Odd ${maxOf(a, b) * 2}"
        }
    )
}
