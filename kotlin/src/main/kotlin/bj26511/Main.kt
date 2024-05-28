package bj26511

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val str = br.readLine()
        val map = mutableMapOf<Char, Int>()
        str.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val sortedMap = map.toList().sortedBy { it.second }
        var count = map.size
        var result = 0
        sortedMap.forEach {
            if (count > 2) {
                if (it.first in 'a'..'z') {
                    count--
                    result += it.second
                }
            } else {
                return@forEach
            }
        }
        println(result)
    }
}
