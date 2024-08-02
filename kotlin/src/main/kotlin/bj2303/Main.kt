package bj2303

import java.io.*
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val cards = Array(n) { br.readLine().split(" ").map { it.toInt() } }
    var winnerIdx = 1
    var max = -1
    cards.forEachIndexed { idx, card ->
        val score = calScore(card)
        if (score >= max) {
            max = score
            winnerIdx = idx + 1
        }
    }
    println(winnerIdx)
}

fun calScore(cards: List<Int>): Int {
    var maxScore = 0
    for (i in 0 until 3) {
        for (j in i + 1 until 4) {
            for (k in j + 1 until 5) {
                val score = (cards[i] + cards[j] + cards[k]) % 10
                maxScore = max(maxScore, score)
            }
        }
    }
    return maxScore
}
