package bj1500

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (s, k) = br.readLine().split(" ").map { it.toInt() }
    val div = s / k
    val mod = s % k
    val array = IntArray(k) { div }
    for (i in 0 until mod) {
        array[i]++
    }
    var result: Long = 1
    array.forEach { result *= it.toLong() }
    println(result)
    br.close()
}
