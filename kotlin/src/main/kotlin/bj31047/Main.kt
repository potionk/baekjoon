package bj31047

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    repeat(k) {
        val n = br.readLine().toInt()
        val map = mutableMapOf<String, Int>()
        for (i in 0 until n) {
            val (a, b) = br.readLine().split(" ")
            val cost = map.getOrDefault(a, 0)
            map[a] = cost + b.toInt()
        }
        val sorted = map.toList().sortedWith(compareBy({ -it.second }, { it.first }))
        println(sorted.size)
        println(sorted.joinToString("\n") { "${it.first} ${it.second}" })
    }
}
