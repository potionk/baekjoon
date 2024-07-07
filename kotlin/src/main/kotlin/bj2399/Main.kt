package bj2399

import java.io.*
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toLong() }.toLongArray()
    var sum = 0L
    for (i in 0 until n) {
        for (j in 0 until n) {
            sum += abs(list[i] - list[j])
        }
    }
    println(sum)
}
