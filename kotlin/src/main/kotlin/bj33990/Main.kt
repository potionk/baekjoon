package bj33990

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = Int.MAX_VALUE
    for (i in 1..n) {
        val (s, b, d) = br.readLine().split(" ").map { it.toInt() }
        if (s + b + d >= 512) {
            result = min(result, s + b + d)
        }
    }
    if (result == Int.MAX_VALUE) println("-1") else println(result)
}
