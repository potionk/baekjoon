package bj31908

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, List<String>>()
    repeat(n) {
        val (key, value) = br.readLine().split(" ")
        if (value != "-") {
            map[value] = map.getOrDefault(value, emptyList()) + key
        }
    }
    val filteredMap = map.filter { it.value.size == 2 }
    println(filteredMap.size)
    filteredMap.forEach { (_, value) ->
        println("${value[0]} ${value[1]}")
    }
}
