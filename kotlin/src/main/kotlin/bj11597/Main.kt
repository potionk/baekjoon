package bj11597

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Int>()
    repeat(n) {
        list.add(br.readLine().toInt())
    }
    list.sort()
    var min = Int.MAX_VALUE
    for (i in 0 until n / 2) {
        min = minOf(min, list[i] + list[n - i - 1])
    }
    println(min)
}
