package bj5359

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, m, c) = br.readLine().split(" ").map { it.toInt() }
        val volumes = br.readLine().split(" ").map { it.toInt() }
        var count = 0
        for (i in 0..(n - m)) {
            val window = volumes.slice(i until i + m)
            if (window.maxOrNull()!! - window.minOrNull()!! <= c) {
                count++
            }
        }
        println(count)
    }
}
