package bj30794

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (lv, str) = br.readLine().split(" ")
    val level = lv.toInt()
    val score = when (str) {
        "miss" -> 0
        "bad" -> 200
        "cool" -> 400
        "great" -> 600
        "perfect" -> 1000
        else -> 0
    }
    println(level * score)
}
