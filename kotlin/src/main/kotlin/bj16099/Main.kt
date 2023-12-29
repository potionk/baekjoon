package bj16099

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a, b, c, d) = br.readLine().split(" ").map { it.toLong() }
        if (a * b > c * d) println("TelecomParisTech")
        else if (a * b < c * d) println("Eurecom")
        else println("Tie")
    }
}
