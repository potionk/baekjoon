package bj16674

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    val map = mutableMapOf<Char, Int>()
    n.forEach {
        if (it != '2' && it != '0' && it != '1' && it != '8') {
            println(0)
            return
        }
        map[it] = map.getOrDefault(it, 0) + 1
    }
    if (map.size == 4) {
        if (map.values.all { it == map.values.first() }) {
            println(8)
        } else {
            println(2)
        }
    } else {
        println(1)
    }
}
