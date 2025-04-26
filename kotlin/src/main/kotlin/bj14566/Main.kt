package bj14566

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val coordinates = br.readLine().split(" ").map { it.toInt() }.sorted()

    var min = Int.MAX_VALUE
    var count = 0

    for (i in 0 until n - 1) {
        val distance = coordinates[i + 1] - coordinates[i]
        if (distance < min) {
            min = distance
            count = 1
        } else if (distance == min) {
            count++
        }
    }

    println("$min $count")
}
