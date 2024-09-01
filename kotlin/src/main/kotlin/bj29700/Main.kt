package bj29700

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    var count = 0
    repeat(n) {
        val line = br.readLine()
        var start = 0
        var end = 0
        while (end < m) {
            if (line[end] == '0') {
                if (end - start + 1 == k) {
                    count++
                    start++
                }
            } else {
                start = end + 1
            }
            end++
        }
    }
    println(count)
}
