package bj17520

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 1L
    for (i in 0 until n / 2) {
        result = (result * 2) % 16769023
    }
    if (n % 2 == 1) {
        result = (result * 2) % 16769023
    }
    println(result)
}
