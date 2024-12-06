package bj15233

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, g) = br.readLine().split(" ").map { it.toInt() }
    val aTeamNameSet = br.readLine().split(" ").map { it.trim() }.toSet()
    val bTeamNameSet = br.readLine().split(" ").map { it.trim() }.toSet()
    var scoredPlayer = br.readLine().split(" ").map { it.trim() }
    scoredPlayer = scoredPlayer.subList(0, g)
    val aScore = scoredPlayer.count { it in aTeamNameSet }
    val bScore = scoredPlayer.size - aScore
    println(
        if (aScore > bScore) {
            "A"
        } else if (aScore < bScore) {
            "B"
        } else {
            "TIE"
        }
    )
}
