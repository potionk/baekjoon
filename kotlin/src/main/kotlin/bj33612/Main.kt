package bj33612

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    println("${(2024 + (8 + (n - 1) * 7 - 1) / 12)} ${(8 + (n - 1) * 7 - 1) % 12 + 1}")
}
