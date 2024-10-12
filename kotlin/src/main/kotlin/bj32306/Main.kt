package bj32306

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    val (d, e, f) = br.readLine().split(" ").map { it.toInt() }
    val team1Score = a + 2 * b + 3 * c
    val team2Score = d + 2 * e + 3 * f
    if (team1Score > team2Score) {
        println("1")
    } else if (team1Score < team2Score) {
        println("2")
    } else {
        println("0")
    }
}
