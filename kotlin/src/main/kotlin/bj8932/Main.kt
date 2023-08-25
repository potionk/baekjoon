package bj8932

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    for (i in 1..n) {
        val p = br.readLine().split(" ").map { it.toDouble() }
        var score = 0
        score += (9.23076 * (26.7 - p[0]).pow(1.835)).toInt()
        score += (4.99087 * (42.5 - p[3]).pow(1.81)).toInt()
        score += (0.11193 * (254 - p[6]).pow(1.88)).toInt()
        score += (1.84523 * (p[1] - 75).pow(1.348)).toInt()
        score += (56.0211 * (p[2] - 1.5).pow(1.05)).toInt()
        score += (0.188807 * (p[4] - 210).pow(1.41)).toInt()
        score += (15.9803 * (p[5] - 3.8).pow(1.04)).toInt()
        println(score)
    }
}
