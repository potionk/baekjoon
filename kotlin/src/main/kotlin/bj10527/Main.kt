package bj10527

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map1 = mutableMapOf<String, Int>()
    val map2 = mutableMapOf<String, Int>()
    repeat(n) {
        val key = br.readLine()
        map1[key] = map1.getOrDefault(key, 0) + 1
    }
    repeat(n) {
        val key = br.readLine()
        map2[key] = map2.getOrDefault(key, 0) + 1
    }
    var result = 0
    map1.forEach { (key, value) ->
        if (map2.containsKey(key)) {
            result += minOf(value, map2[key]!!)
        }
    }
    println(result)
}
