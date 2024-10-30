package bj28648

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var result = Int.MAX_VALUE
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        result = minOf(result, a + b)
    }
    println(result)
}
