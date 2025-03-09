package bj33179

import java.io.*
import kotlin.math.ceil

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toDouble() }
    var result = 0
    for (i in 0 until n) {
        result += ceil(list[i] / 2).toInt()
    }
    println(result)
}
