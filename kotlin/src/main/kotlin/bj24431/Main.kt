package bj24431

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (n, l, f) = br.readLine().split(" ").map { it.toInt() }
        val words = br.readLine().split(" ")
        var max = 0
        for (i in f..l) {
            val map = mutableMapOf<String, Int>()
            words.forEach {
                if (it.length >= i) {
                    val str = it.substring(it.length - i)
                    map[str] = map.getOrDefault(str, 0) + 1
                }
            }
            val count = map.filter { it.value > 1 }.values.sumOf { it / 2 }
            max = max.coerceAtLeast(count)
        }
        println(max)
    }
}
