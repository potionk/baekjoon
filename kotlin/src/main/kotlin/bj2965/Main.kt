package bj2965

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    println(
        when {
            b - a > c - b -> {
                b - a - 1
            }

            else -> {
                c - b - 1
            }
        }
    )
    br.close()
}
