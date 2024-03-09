package bj25191

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    println(min(n, a / 2 + b))
}
