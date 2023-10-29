package bj23795

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var sum = 0
    while (true) {
        val input = br.readLine().toInt()
        if (input == -1) break
        sum += input
    }
    println(sum)
}
