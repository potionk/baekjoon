package bj32888

import java.io.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b) = br.readLine().split(" ").map { it.toDouble() }
    println(sqrt(a * a + b * b).toBigDecimal().toPlainString())
}
