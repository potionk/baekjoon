package bj32386

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val info = br.readLine().split(" ")
        val num = info[1].toInt()
        for (j in 2 until num + 2) {
            val a = info[j]
            map[a] = map.getOrDefault(a, 0) + 1
        }
    }
    val max = map.maxByOrNull { it.value }!!.value
    if (map.values.count { it == max } > 1) {
        println(-1)
    } else {
        println(map.maxByOrNull { it.value }!!.key)
    }
}
