package bj17576

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val n = br.readLine().toInt()
    var left = 0
    var right = 0
    for (i in 1..n) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        left += x
        if (i == n) {
            right += y + left
        }
    }
    println(str.substring(left, right))
}
