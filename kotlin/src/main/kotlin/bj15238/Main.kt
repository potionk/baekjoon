package bj15238

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    val map = mutableMapOf<Char, Int>()
    br.readLine().forEach { map[it] = map.getOrDefault(it, 0) + 1 }
    val max = map.maxByOrNull { it.value }
    println(max!!.key + " " + max.value)
}
