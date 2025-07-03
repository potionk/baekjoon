package bj18247

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        val row = 'L' - 'A' + 1
        val col = 4
        if (row > n || col > m) {
            println(-1)
        } else {
            println((row - 1) * m + col)
        }
    }
}
