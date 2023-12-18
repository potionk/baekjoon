package bj30224

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    if (n.contains('7')) {
        if (n.toInt() % 7 == 0) {
            println("3")
        } else {
            println("2")
        }
    } else {
        if (n.toInt() % 7 == 0) {
            println("1")
        } else {
            println("0")
        }
    }
}
