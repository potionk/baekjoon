package bj30468

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (str, dex, int, luk, n) = br.readLine().split(" ").map { it.toInt() }
    println("${max(0, (n * 4) - (str + dex + int + luk))}")
}
