package bj30031

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var total = 0
    repeat(n) {
        val (width, height) = br.readLine().split(" ").map { it.toInt() }
        total += calMoney(width)
    }
    println(total)
}

fun calMoney(width: Int): Int {
    return when (width) {
        136 -> 1000
        142 -> 5000
        148 -> 10000
        154 -> 50000
        else -> 0
    }
}
