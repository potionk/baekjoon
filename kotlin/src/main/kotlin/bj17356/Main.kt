package bj17356

import java.io.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toDouble() }
    val m = (b - a) / 400
    println(1 / (1 + 10.0.pow(m)))
}
