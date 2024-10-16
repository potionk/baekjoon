package bj13670

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val (h1, m1, h2, m2) = br.readLine().split(" ").map { it.toInt() }
        if (h1 == 0 && m1 == 0 && h2 == 0 && m2 == 0) return
        var t1 = h1 * 60 + m1
        val t2 = h2 * 60 + m2
        if (t1 > t2) t1 -= 1440
        println(-1 * (t1 - t2))
    }
}
