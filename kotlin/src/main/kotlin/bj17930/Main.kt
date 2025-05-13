package bj17930

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (l, x) = br.readLine().split(" ").map { it.toInt() }
    var count = 0
    var current = 0
    repeat(x) {
        val (command, num) = br.readLine().split(" ")
        if (command == "enter") {
            if (current + num.toInt() > l) {
                count++
            } else {
                current += num.toInt()
            }
        } else {
            current -= num.toInt()
        }
    }
    println(count)
}