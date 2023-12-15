package bj30501

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val str = br.readLine()
        if (str.toSet().contains('S')) {
            println(str)
            return
        }
    }
}
