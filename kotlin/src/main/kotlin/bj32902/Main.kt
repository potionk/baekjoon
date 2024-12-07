package bj32902

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    println("${n + 1} ${k * n + 1}")
}
