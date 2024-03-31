package bj4435

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val gandalf = br.readLine().split(" ").map { it.toInt() }
        val sauron = br.readLine().split(" ").map { it.toInt() }
        val gandalfPower = calGandalfScore(gandalf)
        val sauronPower = calSauronScore(sauron)
        if (gandalfPower > sauronPower) println("Battle ${it + 1}: Good triumphs over Evil")
        else if (gandalfPower < sauronPower) println("Battle ${it + 1}: Evil eradicates all trace of Good")
        else println("Battle ${it + 1}: No victor on this battle field")

    }
}

fun calGandalfScore(arr: List<Int>): Int {
    var score = 0
    val gandalfScore = listOf(1, 2, 3, 3, 4, 10)
    for (i in arr.indices) {
        score += gandalfScore[i] * arr[i]
    }
    return score
}

fun calSauronScore(arr: List<Int>): Int {
    var score = 0
    val sauronScore = listOf(1, 2, 2, 2, 3, 5, 10)
    for (i in arr.indices) {
        score += sauronScore[i] * arr[i]
    }
    return score
}
