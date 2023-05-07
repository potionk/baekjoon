package bj2476

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var max = 0
    for (i in 0 until n) {
        val (a, b, c) = br.readLine().split(" ").sorted().map { it.toInt() }
        max = if (a == b && b == c) {
            max(max, 10000 + a * 1000)
        } else if (a == b || b == c || a == c) {
            max(max, 1000 + b * 100)
        } else {
            max(max, c * 100)
        }
    }
    println(max)
    br.close()
}
