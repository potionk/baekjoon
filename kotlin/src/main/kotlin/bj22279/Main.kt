package bj22279

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = 0.0
    repeat(n) {
        val (q, y) = br.readLine().split(" ").map { it.toDouble() }
        result += q * y
    }
    println("%.3f".format(result))
}
