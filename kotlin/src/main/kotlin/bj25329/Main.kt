package bj25329

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val (time, name) = br.readLine().split(" ").map { it.trim() }
        map[name] = map.getOrDefault(name, 0) + strToMin(time)
    }
    val list =map.toList()
        .map { Pair(it.first, getCharge(it.second)) }
        .sortedWith(compareBy({ -it.second }, { it.first }))
    list.forEach {
        println("${it.first} ${it.second}")
    }
}

fun strToMin(str: String): Int {
    val (h, m) = str.split(":").map { it.toInt() }
    return h * 60 + m
}

fun getCharge(min: Int): Int {
    if (min <= 100) return 10
    return 10 + ((min - 100 + 49) / 50) * 3
}
