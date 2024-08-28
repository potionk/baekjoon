package bj28281

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, x) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    var total = list[0] + list[1]
    var result = total
    for (i in 1 until n - 1) {
        total -= list[i - 1]
        total += list[i + 1]
        if (total < result) result = total
    }
    println(result * x)
}
