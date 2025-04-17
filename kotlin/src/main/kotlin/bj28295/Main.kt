package bj28295

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var direction = 0
    repeat(10) {
        direction = (direction + br.readLine().toInt()) % 4
    }
    println(
        when (direction) {
            0 -> "N"
            1 -> "E"
            2 -> "S"
            3 -> "W"
            else -> ""
        }
    )
}
