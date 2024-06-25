package bj2460

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = 0
    var max = 0
    for(i in 0 until 10) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        count += b - a
        max = maxOf(max, count)
    }
    print(max)
}
