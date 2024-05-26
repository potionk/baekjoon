package bj27496

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, l) = br.readLine().split(" ").map { it.toInt() }
    val drinks = br.readLine().split(" ").map { it.toLong() }
    var sum = 0L
    var result = 0
    for (i in 0 until l) {
        sum += drinks[i]
        check(sum).let { if (it) result++ }
    }
    for (i in l until n) {
        sum += drinks[i] - drinks[i - l]
        check(sum).let { if (it) result++ }
    }
    println(result)
}

fun check(value: Long): Boolean {
    return value in 129..138
}
