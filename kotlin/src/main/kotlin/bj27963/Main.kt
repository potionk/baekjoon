package bj27963

import java.io.*
import kotlin.math.min
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (d1, d2, chiPercent) = br.readLine().split(" ").map { it.toDouble() }
    val chi = chiPercent / 100.0
    println(1.0 / ((1 - chi) / min(d1, d2) + chi / max(d1, d2)))
}