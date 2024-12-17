package bj17598

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var lionCount = 0
    var tigerCount = 0
    repeat(9) {
        val line = br.readLine()
        when (line) {
            "Lion" -> lionCount++
            "Tiger" -> tigerCount++
        }
    }
    println(if (lionCount > tigerCount) "Lion" else "Tiger")
}
