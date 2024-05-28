package bj10025

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    repeat(n) {
        val (g, x) = br.readLine().split(" ").map { it.toInt() }
        map[x] = g
    }
    var total = 0
    var max = 0
    for (i in 0..k * 2) {
        total += map.getOrDefault(i, 0)
        max = total
    }
    for (i in k * 2 + 1..1000000) {
        total += map.getOrDefault(i, 0)
        total -= map.getOrDefault(i - k * 2 - 1, 0)
        max = max.coerceAtLeast(total)
    }
    println(max)
}
