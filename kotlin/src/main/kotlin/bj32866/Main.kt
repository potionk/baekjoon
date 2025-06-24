package bj32866

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toDouble()
    val currentPrice = n * (1 - br.readLine().toDouble() / 100.0)
    println(((n / currentPrice) - 1) * 100.0)
}
