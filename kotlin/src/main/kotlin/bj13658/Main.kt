package bj13658

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val input = br.readLine()
        if (input == "0 0") break
        val (a, b) = input.split(" ")
        println(("0" + b.filter { it != a[0] }).toBigInteger())
    }
}
