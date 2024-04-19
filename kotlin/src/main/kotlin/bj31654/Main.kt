package bj31654

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    println(if (a + b == c) "correct!" else "wrong!")
}
