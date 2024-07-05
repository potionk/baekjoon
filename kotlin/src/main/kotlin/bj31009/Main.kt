package bj31009

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        map[a] = b.toInt()
    }
    val jinjuCost = map["jinju"]!!
    println(jinjuCost)
    var count = 0
    map.forEach {
        if (it.value > jinjuCost) {
            count++
        }
    }
    println(count)
}
