package bj20044

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val scores = br.readLine().split(" ").map { it.toInt() }.sorted()
    val teamScores = mutableListOf<Int>()
    for (i in 0 until n) {
        teamScores.add(scores[i] + scores[2 * n - i - 1])
    }
    println(teamScores.sorted()[0])
    br.close()
}
