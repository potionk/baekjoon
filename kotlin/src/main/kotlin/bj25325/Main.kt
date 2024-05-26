package bj25325

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val students = br.readLine().split(" ")
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val like = br.readLine().split(" ")
        like.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
    }
    students.sortedWith(compareBy({ -1 * map.getOrDefault(it, 0) }, { it })).forEach {
        println("$it ${map.getOrDefault(it, 0)}")
    }
}
