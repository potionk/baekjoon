package bj29097

import java.io.*
import kotlin.math.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val info = br.readLine().split(" ").map { it.toInt() }
    val aScore = info[0] * info[3]
    val bScore = info[1] * info[4]
    val cScore = info[2] * info[5]
    val maxScore = max(max(aScore, bScore), cScore)
    if(aScore == maxScore) print("Joffrey ")
    if(bScore == maxScore) print("Robb ")
    if(cScore == maxScore) print("Stannis")
}