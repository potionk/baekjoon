package bj30143

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, a, d) = br.readLine().split(" ").map { it.toInt() }
        println(n * (2 * a + (n - 1) * d) / 2)
    }
}
