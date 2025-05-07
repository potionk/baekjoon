package bj29725

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val scoreMap = mapOf(
        'P' to 1, 'p' to 1,
        'N' to 3, 'n' to 3,
        'B' to 3, 'b' to 3,
        'R' to 5, 'r' to 5,
        'Q' to 9, 'q' to 9,
        'K' to 0, 'k' to 0
    )

    var whiteScore = 0
    var blackScore = 0

    repeat(8) {
        val line = br.readLine()
        for (c in line) {
            if (c == '.') continue
            val value = scoreMap[c] ?: 0
            if (c.isUpperCase()) {
                whiteScore += value
            } else {
                blackScore += value
            }
        }
    }

    println(whiteScore - blackScore)
}