package bj21633

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toDouble()
    println(String.format("%.02f", min(max(100.0, 25 + k * 0.01), 2000.0)))
}
