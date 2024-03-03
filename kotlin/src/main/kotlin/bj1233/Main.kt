package bj1233

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    for (i in 1..a) {
        for (j in 1..b) {
            for (k in 1..c) {
                val sum = i + j + k
                map[sum] = map.getOrDefault(sum, 0) + 1
            }
        }
    }
    val max = map.maxByOrNull { it.value }!!.value
    val result = map.filter { it.value == max }.minByOrNull { it.key }!!.key
    println(result)
}
