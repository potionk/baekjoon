package bj25775

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<Int, MutableMap<String, Int>>()
    repeat(n) {
        val charArray = br.readLine().toCharArray()
        for (i in charArray.indices) {
            if (map[i] == null) {
                map[i] = mutableMapOf()
            }
            map[i]!![charArray[i].toString()] = map[i]!!.getOrDefault(charArray[i].toString(), 0) + 1
        }
    }
    for (i in 0 until map.size) {
        val max = map[i]!!.maxByOrNull { it.value }!!
        print("${i + 1}: ")
        map[i]!!.filter { it.value == max.value }.map { it.key }.sorted().forEach {
            print("$it ")
        }
        println()
    }
}
