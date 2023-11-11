package bj27855

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (h1, b1) = br.readLine().split(" ").map { it.toInt() }
    val score1 = h1 * 3 + b1
    val (h2, b2) = br.readLine().split(" ").map { it.toInt() }
    val score2 = h2 * 3 + b2
    when {
        score1 > score2 -> println("1 ${score1 - score2}")
        score2 > score1 -> println("2 ${score2 - score1}")
        else -> println("NO SCORE")
    }
}
