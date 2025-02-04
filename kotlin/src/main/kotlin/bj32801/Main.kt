package bj32801

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, a, b) = br.readLine().split(" ").map { it.toInt() }
    var fizzCount = 0
    var buzzCount = 0
    var fizzBuzzCount = 0
    for (i in 1..n) {
        if (i % a == 0 && i % b == 0) {
            fizzBuzzCount++
        } else if (i % a == 0) {
            fizzCount++
        } else if (i % b == 0) {
            buzzCount++
        }
    }
    println("$fizzCount $buzzCount $fizzBuzzCount")
}
