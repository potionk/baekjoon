package bj8974

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toLong() }
    println(min(abs((a - (a / 2) * 2) * b), abs((b - (b / 2) * 2) * a)))
}
