package bj13623

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    if (a == b && b == c) println("*")
    else if (a == b) println("C")
    else if (b == c) println("A")
    else println("B")
}
