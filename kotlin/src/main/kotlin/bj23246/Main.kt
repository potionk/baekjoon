package bj23246

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Triple<Int, Int, Int>>()
    repeat(n) {
        val (b, p, q, r) = br.readLine().split(" ").map { it.toInt() }
        list.add(Triple(p * q * r, p + q + r, b))
    }
    list.sortWith(compareBy({ it.first }, { it.second }, { it.third }))
    println(list.dropLast(n - 3).joinToString(" ") { it.third.toString() })
}
