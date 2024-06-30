package bj2022

import java.io.*
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (x, y, c) = br.readLine().split(" ").map { it.toDouble() }
    var left = 0.0
    var right = minOf(x, y)
    while (right - left > 0.0001) {
        val d = (left + right) / 2
        val hx = sqrt(x * x - d * d)
        val hy = sqrt(y * y - d * d)
        val thisC = hx * hy / (hx + hy)
        if (thisC > c) {
            left = d
        } else {
            right = d
        }
    }
    println(left)
}
