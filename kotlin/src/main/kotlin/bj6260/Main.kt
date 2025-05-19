package bj6260

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val letterPrev = mapOf(
        'A' to 'C', 'B' to 'A', 'C' to 'B', // 2
        'D' to 'F', 'E' to 'D', 'F' to 'E', // 3
        'G' to 'I', 'H' to 'G', 'I' to 'H', // 4
        'J' to 'L', 'K' to 'J', 'L' to 'K', // 5
        'M' to 'O', 'N' to 'M', 'O' to 'N', // 6
        'P' to 'S', 'Q' to 'P', 'R' to 'Q', 'S' to 'R', // 7
        'T' to 'V', 'U' to 'T', 'V' to 'U', // 8
        'W' to 'Z', 'X' to 'W', 'Y' to 'X', 'Z' to 'Y'  // 9
    )

    while (true) {
        val line = br.readLine()
        if (line == "#") break
        val result = line.mapIndexed { i, ch ->
            val isLower = ch.isLowerCase()
            var upper = ch.uppercaseChar()
            repeat(i + 1) {
                upper = letterPrev[upper]!!
            }
            if (isLower) upper.lowercaseChar() else upper
        }.joinToString("")

        println(result)
    }
}