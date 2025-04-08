package bj31262

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val alphabets = str.substring(0..2).toCharArray().sorted()
    val numbers = str.substring(3..5).toCharArray().map { it.code - 48 }.sortedDescending()
    for (i in 0..2) {
        print(alphabets[i])
        print(numbers[i])
    }
}
