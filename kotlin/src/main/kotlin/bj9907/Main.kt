package bj9907

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val weights = listOf(2, 7, 6, 5, 4, 3, 2)
    val checkDigitMap = mapOf(
        0 to 'J',
        1 to 'A',
        2 to 'B',
        3 to 'C',
        4 to 'D',
        5 to 'E',
        6 to 'F',
        7 to 'G',
        8 to 'H',
        9 to 'I',
        10 to 'Z'
    )

    val br = BufferedReader(InputStreamReader(System.`in`))
    val input = br.readLine()
    var sum = 0
    for (i in input.indices) {
        sum += input[i].toString().toInt() * weights[i]
    }
    val checkDigit = sum % 11

    println("${checkDigitMap[checkDigit]}")
}
