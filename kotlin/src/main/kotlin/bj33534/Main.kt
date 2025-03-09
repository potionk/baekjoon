package bj33534

import java.io.*
import kotlin.math.ceil
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val f = br.readLine().toDouble()
    println(String.format("%.1f", ceil(2.0 * sqrt(Math.PI * f) * 10) / 10))
}
