package bj31868

import java.io.*
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    println(k / (2.0.pow(n.toDouble() - 1).toInt()))
}
