package bj26592

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toDouble() }
        val h = (2 * a) / b
        println("The height of the triangle is ${"%.2f".format(h)} units")
    }
}
