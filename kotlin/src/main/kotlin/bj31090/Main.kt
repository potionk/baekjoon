package bj31090

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val year = br.readLine().toInt()
        println(if (checkYear(year)) "Good" else "Bye")
    }
}

fun checkYear(year: Int): Boolean {
    return (year + 1) % (year % 100) == 0
}
