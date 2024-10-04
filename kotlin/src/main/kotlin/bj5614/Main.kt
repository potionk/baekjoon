package bj5614

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        var value = map.getOrDefault(a, 0)
        value += b.toInt()
        map[a] = value
    }
    map.toList().sortedWith(compareBy({ it.first.length }, { it.first })).forEach {
        println("${it.first} ${it.second}")
    }
}
