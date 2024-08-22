package bj28417

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var winnerScore = 0
    repeat(n) {
        val scores = br.readLine().split(" ").map { it.toInt() }
        val score = max(scores[0], scores[1]) + scores.drop(2).sorted().reversed().subList(0, 2).sum()
        if (score > winnerScore) {
            winnerScore = score
        }
    }
    println(winnerScore)
}
