package bj5591

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(n)
    repeat(n) {
        array[it] = br.readLine().toInt()
    }
    var total = array.slice(0 until k).sum()
    var max = total
    for (i in k until n) {
        total += array[i] - array[i - k]
        max = max(max, total)
    }
    println(max)
}
