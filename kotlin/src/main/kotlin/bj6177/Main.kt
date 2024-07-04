package bj6177

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Double>()
    for (i in 0 until n) {
        list.add(br.readLine().toDouble())
    }
    list.sort()
    println(list.sum() / n)
    if (n % 2 == 0) {
        println((list[n / 2 - 1] + list[n / 2]) / 2)
        return
    }
    println(list[n / 2])
}
