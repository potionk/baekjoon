package bj28444

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h, i, a, r, c) = br.readLine().split(" ").map { it.toInt() }
    println((h * i) - (a * r * c))
}
