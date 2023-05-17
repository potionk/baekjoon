package bj14724

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val clubs = listOf("PROBRAIN", "GROW", "ARGOS", "ADMIN", "ANT", "MOTION", "SPG", "COMON", "ALMIGHTY")
    val n = br.readLine().toInt()
    var adminIdx = -1
    var adminScore = -1
    for (i in clubs.indices) {
        val scores = br.readLine().split(" ").map { it.toInt() }.sorted().reversed()
        if (scores[0] > adminScore) {
            adminIdx = i
            adminScore = scores[0]
        }
    }
    println(clubs[adminIdx])
    br.close()
}
