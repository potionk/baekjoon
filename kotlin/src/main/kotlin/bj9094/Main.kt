package bj9094

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        var count = 0
        for (a in 1 until n) {
            for (b in a + 1 until n) {
                if ((a * a + b * b + m) % (a * b) == 0) {
                    count++
                }
            }
        }
        println(count)
    }
}
