package bj30793

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (p, r) = br.readLine().split(" ").map { it.toDouble() }
    val score = p / r
    if (score >= 0.6) {
        println("very strong")
    } else if (score >= 0.4) {
        println("strong")
    } else if (score >= 0.2) {
        println("normal")
    } else {
        println("weak")
    }
}
