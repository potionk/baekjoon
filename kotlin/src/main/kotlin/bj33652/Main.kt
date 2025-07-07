package bj33652

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = Long.MAX_VALUE
    repeat(n) {
        val (m, o) = br.readLine().split(" ").map { it.toLong() }
        if (o == 0L) {
            if (m < result) {
                result = m
            }
        }
    }

    println(if (result == Long.MAX_VALUE) -1 else result)
}