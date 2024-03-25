package bj11235

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    repeat(n) {
        val s = br.readLine()
        map[s] = map.getOrDefault(s, 0) + 1
    }
    val max = map.values.maxOrNull()!!
    println(map.filter { it.value == max }.keys.sorted().joinToString("\n"))
}
