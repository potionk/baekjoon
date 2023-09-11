package bj28490

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var max = -1
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        max = max(max, a * b)
    }
    println(max)
}
