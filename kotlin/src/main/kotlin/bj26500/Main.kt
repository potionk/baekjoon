package bj26500

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toDouble() }
        println(String.format("%.1f", abs(b-a)))
    }
}
