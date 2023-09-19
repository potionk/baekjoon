package bj25784

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (a == b + c || b == a + c || c == a + b) {
            1
        } else if (a == b * c || b == a * c || c == a * b) {
            2
        } else {
            3
        }
    )
}
