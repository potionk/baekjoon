package bj27522

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = mutableListOf<SpeedRecord>()
    repeat(8) {
        val (record, team) = br.readLine().split(" ")
        val (min, sec, ms) = record.split(":").map { it.toInt() }
        list.add(SpeedRecord(min, sec, ms, team))
    }
    list.sortWith(compareBy<SpeedRecord> { it.min }.thenBy { it.sec }.thenBy { it.ms })
    val scoreBoard = listOf(10, 8, 6, 5, 4, 3, 2, 1, 0)
    var redScore = 0
    var blueScore = 0
    for (i in 0 until 8) {
        if (list[i].team == "R") {
            redScore += scoreBoard[i]
        } else {
            blueScore += scoreBoard[i]
        }
    }
    println(if (redScore > blueScore) "Red" else "Blue")
}

data class SpeedRecord(
    val min: Int,
    val sec: Int,
    val ms: Int,
    val team: String
)
