package bj31798

import java.io.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    if (a == 0) {
        println(c * c - b)
    } else if (b == 0) {
        println(c * c - a)
    } else {
        println(sqrt((a + b).toDouble()).toInt())
    }
}