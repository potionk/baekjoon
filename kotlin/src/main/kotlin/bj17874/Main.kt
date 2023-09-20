package bj17874

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, h, v) = br.readLine().split(" ").map { it.toInt() }
    val thick = 4
    val topLeft = h * v * thick
    val topRight = h * (n - v) * thick
    val bottomLeft = (n - h) * v * thick
    val bottomRight = (n - h) * (n - v) * thick
    println(maxOf(topLeft, topRight, bottomLeft, bottomRight))
}
