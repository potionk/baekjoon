package bj14065

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val x = br.readLine().toDouble()
    println(100 * 3.785411784 / (1.609344 * x))
}
