package bj18238

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    var time = 0
    var prev = 'A'
    for (c in str) {
        val diff = abs(c - prev)
        time += diff.coerceAtMost(26 - diff)
        prev = c
    }
    println(time)
    br.close()
}
