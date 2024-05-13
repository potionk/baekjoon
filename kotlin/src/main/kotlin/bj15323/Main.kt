package bj15323

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (k, n) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Char, MutableList<String>>()
    val count = mutableMapOf<Char, Int>()
    repeat(k) {
        val str = br.readLine()
        map[str[0]] = map.getOrDefault(str[0], mutableListOf()).apply { add(str) }
    }
    map.forEach {
        it.value.sort()
    }
    repeat(n) {
        val c = br.readLine()[0]
        val idx = count.getOrDefault(c, 0) % map[c]!!.size
        println(map[c]!![idx])
        count[c] = idx + 1
    }
}
