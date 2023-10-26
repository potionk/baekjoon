package bj25858

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, d) = br.readLine().split(" ").map { it.toInt() }
    val solvedProblems = mutableListOf<Int>()
    for (i in 0 until n) {
        solvedProblems.add(br.readLine().toInt())
    }
    val rewardPerProblem = d / solvedProblems.sum()
    println(solvedProblems.joinToString("\n") { (it * rewardPerProblem).toString() })
}
