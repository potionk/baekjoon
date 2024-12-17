package bj14544

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val map = mutableMapOf<String, Int>()
        repeat(a) {
            br.readLine()
        }
        repeat(b) {
            val (c, d, e) = br.readLine().split(" ")
            map[c] = map.getOrDefault(c, 0) + d.toInt()
        }
        val max = map.maxByOrNull { it.value }!!
        val maxCount = map.count { it.value == max.value }
        println(
            if (maxCount == 1) {
                "VOTE $i: THE WINNER IS ${max.key} ${max.value}"
            } else {
                "VOTE $i: THERE IS A DILEMMA"
            }
        )
    }
}
