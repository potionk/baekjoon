package bj32905

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val matrix = List(n) {
        br.readLine().split(" ")
    }
    for (row in matrix) {
        val aCount = row.count { it == "A" }
        if (aCount != 1) {
            println("No")
            return
        }
    }
    println("Yes")
}
