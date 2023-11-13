package bj9612

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val key = br.readLine()
        map[key] = map.getOrDefault(key, 0) + 1
    }
    val result = map.map { Pair(it.key, it.value) }
        .sortedWith(compareBy<Pair<String, Int>>({ it.second }, { it.first }).reversed()).first()
    println("${result.first} ${result.second}")
}
