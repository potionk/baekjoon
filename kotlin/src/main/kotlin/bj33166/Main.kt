package bj33166

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (p, q) = br.readLine().split(" ").map { it.toInt() }
    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (p >= q) {
            q * a
        } else {
            p * a + (q - p) * b
        }
    )
}
