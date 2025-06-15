package bj33249

import java.io.*
import kotlin.math.PI

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (d, h) = br.readLine().split(" ").map { it.toDouble() }
    val r = (d + 10.0) / 2.0
    println(PI * r * (2 * h + r))
}