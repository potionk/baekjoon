package bj32025

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val h = br.readLine().toInt()
    val w = br.readLine().toInt()
    println(minOf(h, w) * 100 / 2)
}
