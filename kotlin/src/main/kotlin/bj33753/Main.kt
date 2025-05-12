package bj33753

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
    val t = br.readLine().toInt()
    var result = a
    if (t > 30) {
        result += ((t - 30) + b - 1) / b * c
    }
    println(result)
}
