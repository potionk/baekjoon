package bj9699

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        println("Case #${it + 1}: ${br.readLine().split(" ").map { it.toInt() }.maxOrNull()}")
    }
}
