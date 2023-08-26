package bj2484

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var max = 0
    for (i in 0 until n) {
        val dice = br.readLine().split(" ").map { it.toInt() }
        val score = calculateScore(dice)
        if (score > max) {
            max = score
        }
    }
    println(max)
}

fun calculateScore(dice: List<Int>): Int {
    val map = mutableMapOf<Int, Int>()
    dice.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    return when (map.size) {
        1 -> 50000 + map.keys.first() * 5000
        2 -> {
            if (map.values.maxOf { it } == 3) {
                10000 + map.keys.maxOf { it } * 1000
            } else {
                2000 + map.keys.first() * 500 + map.keys.last() * 500
            }
        }
        3 -> {
            val key = map.keys.first { map[it] == 2 }
            1000 + key * 100
        }
        4 -> {
            val key = map.keys.maxOrNull()!!
            key * 100
        }
        else -> {
            -1
        }
    }
}
